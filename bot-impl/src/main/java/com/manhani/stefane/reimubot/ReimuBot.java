/*
 *  Copyright (C) 2024 Gabriel Zanotim Manhani - IFSP/SCL
 *  Copyright (C) 2024 Polyane Victoria Stefane - IFSP/SCL
 *
 *  Contact: g <dot> manhani <at> aluno <dot> ifsp <dot> edu <dot> br
 *  Contact: p <dot> stefane <at> aluno <dot> ifsp <dot> edu <dot> br
 *
 *  This file is part of CTruco (Truco game for didactic purpose).
 *
 *  CTruco is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  CTruco is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with CTruco.  If not, see <https://www.gnu.org/licenses/>
 */

package com.manhani.stefane.reimubot;

import com.bueno.spi.model.CardToPlay;
import com.bueno.spi.model.GameIntel;
import com.bueno.spi.model.TrucoCard;
import com.bueno.spi.service.BotServiceProvider;

import java.util.Comparator;
import java.util.List;

public class ReimuBot implements BotServiceProvider {
    public static final int REFUSE = -1;
    public static final int ACCEPT = 0;
    public static final int RERAISE = 1;
    
    @Override
    public boolean getMaoDeOnzeResponse(GameIntel intel) {
        return false;
    }

    @Override
    public boolean decideIfRaises(GameIntel intel) {
        return false;
    }

    @Override
    public CardToPlay chooseCard(GameIntel intel) {
        if(isFirstToPlayRound(intel))
            return CardToPlay.of(FirstToPlayStrategy(intel));
        return CardToPlay.of(LastToPlayStrategy(intel));
    }

    @Override
    public int getRaiseResponse(GameIntel intel) {
        return 0;
    }
    
    private int getHandValue(GameIntel intel) {
        return intel.getCards().stream().mapToInt(c -> c.relativeValue(intel.getVira())).sum();
    }
    
    //should only be called after checking if you're not first
    private boolean canDefeatOpponentCard(GameIntel intel) {
        return canDefeatOpponentCard(intel.getCards(), intel.getVira(), intel.getOpponentCard().get());
    }
    private boolean canDefeatOpponentCard(List<TrucoCard> cards, TrucoCard vira, TrucoCard opponentCard){
        return cards.stream().anyMatch(c-> c.compareValueTo(opponentCard,vira) > 0);
    }
    
    private boolean isFirstToPlayRound(GameIntel intel){
        return intel.getOpponentCard().isEmpty();
    }
    
    private boolean isFirstRound(GameIntel intel){
        return intel.getCards().size() == 3;
    }
    
    private boolean isSecondRound(GameIntel intel){
        return intel.getCards().size() == 2;
    }
    
    private boolean isThirdRound(GameIntel intel){
        return intel.getCards().size() == 1;
    }
    
    private TrucoCard getWeakestCard(GameIntel intel){
        return getWeakestCard(intel.getCards(), intel.getVira());
    }
    
    private TrucoCard getWeakestCard(List<TrucoCard> cards, TrucoCard vira){
        return cards.stream().min(Comparator.comparingInt(c->c.relativeValue(vira))).get();
    }

    //should only be called after checking if you're not first
    //should only be called after checking you can win
    private TrucoCard getWeakestCardThatWins(GameIntel intel){
        return getWeakestCardThatWins(intel.getCards(), intel.getVira(), intel.getOpponentCard().get());
    }
    
    private TrucoCard getWeakestCardThatWins(List<TrucoCard> cards, TrucoCard vira, TrucoCard opponentCard){
         cards = cards.stream()
                .filter(c -> c.relativeValue(vira) > opponentCard.relativeValue(vira))
                .toList();
        return getWeakestCard(cards, vira);
    }
    
    //should only be called after checking if you're not first
    private boolean canWinWithoutMaior(GameIntel intel){
        return canDefeatOpponentCard(tryGetCardsThatAreNotMaior(intel), intel.getVira(), intel.getOpponentCard().get());
    }
    //return a list, check if empty to know if any are not maior
    private List<TrucoCard> tryGetCardsThatAreNotMaior(GameIntel intel){
        return intel.getCards().stream().filter(c-> !c.isZap(intel.getVira())&&!c.isCopas(intel.getVira())).toList();
    }
    
    
    private TrucoCard FirstToPlayStrategy(GameIntel intel){
        if(isFirstRound(intel)) return getWeakestCard(tryGetCardsThatAreNotMaior(intel), intel.getVira());
        return getWeakestCard(intel);
    }
    
    private TrucoCard LastToPlayStrategy(GameIntel intel) {
        if (canDefeatOpponentCard(intel)){
            if (isFirstRound(intel) && canWinWithoutMaior(intel))
                return getWeakestCardThatWins(tryGetCardsThatAreNotMaior(intel), intel.getVira(), intel.getOpponentCard().get());
            if(isFirstRound(intel))
                return getWeakestCard(intel);
        return getWeakestCardThatWins(intel);
    }
        return getWeakestCard(intel);
    }

}
