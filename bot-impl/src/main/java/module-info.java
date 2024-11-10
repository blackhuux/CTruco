import com.casal.impl.vapobot.VapoBot;
import com.correacarini.impl.trucomachinebot.TrucoMachineBot;
import com.petrilli.sandro.malasiabot.MalasiaBot;
import com.zampieri.rissatti.impl.UncleBobBot.UncleBobBot;
import com.peixe.aguliari.perdenuncabot.PerdeNuncaBot;

module bot.impl {
    requires bot.spi;
    requires java.compiler;
    requires java.smartcardio;

    exports com.bueno.impl.dummybot;
    exports com.indi.impl.addthenewsoul;
    exports com.hermespiassi.casados.marrecobot;
    exports com.newton.dolensi.sabotabot;
    exports com.cremonezzi.impl.carlsenbot;
    exports com.caueisa.destroyerbot;
    exports com.bonelli.noli.paulistabot;
    exports com.hideki.araujo.wrkncacnterbot;
    exports com.pedrocagiovane.pauladasecabot;
    exports com.brenoduda.cafeconlechebot;
    exports com.aah.refactor.me;
    exports com.rossi.lopes.trucoguru;
    exports com.almeida.strapasson.veiodobar;
    exports com.tatayrapha.leonardabot;
    exports com.murilos.aline.teconomarrecobot;
    exports com.silvabrufato.impl.silvabrufatobot;
    exports com.everton.ronaldo.arrebentabot;
    exports com.yuri.impl;
    exports com.francisco.bruno.pedrohenriquebot;
    exports com.gatti.casaque.caipirasbot;
    exports com.gustavo.contiero.lazybot;
    exports com.fabio.bruno.minepowerbot;
    exports com.joao.alexandre.jormungandrbot;
    exports com.lucasmurilo.m.lazarinipodenciano;
    exports com.otavio.lopes.teitasbot;
    exports com.miguelestevan.jakaredumatubot;
    exports com.soares.gibim.chatgptbot;
    exports com.barbara.lucasCruz.patriciaAparecida;
    exports com.Sigoli.Castro.PatoBot;
    exports com.garcia.orlandi.slayerbot;
    exports com.erick.itaipavabot;
    exports com.renato.DarthVader;
    exports com.antonelli.rufino.bardoalexbot;
    exports com.lucas.felipe.newbot;
    exports com.contiero.lemes.atrasabot;
    exports com.shojisilva.fernasbot;
    exports com.castro.calicchio.jogasafebot;
    exports com.felipe.fabiano.truccard;
    exports com.gabriel.kayky.coisaruim;
    exports com.murilo.joao.jackbot;
    exports com.luna.jundi.jokerBot;
    exports com.carvalho.candido.tomegapbot;
    exports com.bruno.tiago.jeckiechanbot;
    exports com.alanIan.casinhadecabloco;
    exports com.bernardo.caio.zeusbot;
    exports com.motta.impl.beepbot;
    exports com.campos.turazzi.reidozap;
    exports com.daniel.mateus.theroverbot;  
    exports com.belini.luciano.matapatobot;
    exports com.brito.macena.boteco;
    exports com.Selin.Bonelli.zetruquero;
    exports com.luigi.ana.batatafritadobarbot;
    exports com.manhani.stefane.reimubot;
    exports com.adivic.octopus;
    exports com.eduardo.vinicius.camaleaotruqueiro;
    exports com.bianca.joaopedro.lgtbot;
    exports com.adriann.emanuel.armageddon;
    exports com.kayky.waleska.kwtruco;
    exports com.fernando.breno.trucomarrecobot;
    exports com.matos.gusmao.yourdaddy;

    provides com.bueno.spi.service.BotServiceProvider with
            ArrebentaBot,
            AddTheNewSoul,
            WrkncacnterBot,
            MarrecoBot,
            Carlsen,
            DummyBot,
            DestroyerBot,
            PaulistaBot,
            BarDoAlexBot,
            TecoNoMarrecoBot,
            SilvaBrufatoBot,
            LeonardaBot,
            VeioDoBarBot,
            PerdeNuncaBot,
            TrucoMachineBot,
            BotMadeInDescalvado,
            TrucoGuru,
            RefactorMePleaseBot,
            UncleBobBot,
            CafeConLecheBot,
            VapoBot,
            SabotaBot,
            CaipirasBot,
            LazyBot,
            PauladaSecaBot,
            MinePowerBot,
            JormungandrBot,
            Akkosocorrompido,
            JakareDuMatuBot,
            ChatGptBot,
            PatriciaAparecida,
            PatoBot,
            ItaipavaBot,
            DarthVader,
            SlayerBot,
            TeitasBot,
            MalasiaBot,
            FernasBot,
            NewBot,
            AtrasaBot,
            JogaSafeBot,
            Truccard,
            CoisaRuim,
            JackBot,
            JokerBot,
            GapBot,
            JackieChanBot,
            CasinhaDeCabloco,
            BeepBot,
            Zeusbot,
            ReiDoZap,
            TheRover,
            PedroHenriqueBot,
            MataPatoBot,
            BotEco,
            Armageddon,
            Zetruquero,
            BatataFritaDoBarBot,
            ReimuBot,
            Octopus,
            CamaleaoTruqueiro,
            Lgtbot,
            KwTruco,
            TrucoMarreco,
            YourDaddy;
}