package com.example.moviecatalogue.utils

import androidx.lifecycle.LiveData
import com.example.moviecatalogue.R
import com.example.moviecatalogue.data.MovieEntity
import com.example.moviecatalogue.data.TVShowEntity


object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {

        return listOf(
            MovieEntity(1,
                "Luca",
                "Luca and his best friend Alberto experience an unforgettable summer on the Italian Riviera. But all the fun is threatened by a deeply-held secret: they are sea monsters from another world just below the water’s surface.",
                "2021-06-17",
                "8.3",
                "https://image.tmdb.org/t/p/w500/7rhzEufovmmUqVjcbzMHTBQ2SCG.jpg"
            ),
            MovieEntity(2,
                "Alita: Battle Angel",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "02/14/2019",
                "72%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(3,
                "Aquaman",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                "12/21/2018",
                "69%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(4,
                "Bohemian Rhapsody",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "11/02/2018",
                "80%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(5,
                "Cold Pursuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "02/08/2019",
                "57%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(6,
                "Creed II",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "11/21/2018",
                "69%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(7,
                "Fantastic Beasts: The Crimes of Grindelwald",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "11/16/2018 ",
                "69%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(8,
                "Glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "01/18/2019",
                "67%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(9,
                "How to Train Your Dragon",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "03/26/2010",
                "78%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(10,
                "Avengers: Infinity War",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "04/27/2018",
                "83%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ),
            MovieEntity(11,
                "Mary Queen of Scots",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "12/21/2018",
                "66%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            )
        )
    }

    fun generateDummyTVShow(): List<TVShowEntity> {

        val tvshow = ArrayList<TVShowEntity>()

        tvshow.add(
            TVShowEntity(
                84958,
                "Loki",
                "After stealing the Tesseract during the events of “Avengers: Endgame,” an alternate version of Loki is brought to the mysterious Time Variance Authority, a bureaucratic organization that exists outside of time and space and monitors the timeline. They give Loki a choice: face being erased from existence due to being a “time variant”or help fix the timeline and stop a greater threat.",
                "2021-06-09",
                "8.1",
                "https://image.tmdb.org/t/p/w500/kEl2t3OhXc3Zb9FBh1AuYzRTgZp.jpg"


        ))
        tvshow.add(
            TVShowEntity(
                2,
                "Doom Patrol",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "2019",
                "76%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"

        ))

        tvshow.add(
            TVShowEntity(
                3,
                "Dragon Ball",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                "1986",
                "81%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
        ))

        tvshow.add(
            TVShowEntity(
                4,
                "The Umbrella Academy",
                "A dysfunctional family of superheroes comes together to solve the mystery of their father's death, the threat of the apocalypse and more.",
                "2015",
                "87%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ))

        tvshow.add(
            TVShowEntity(
                5,
                "Family Guy",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "1999",
                "70%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"

            ))

        tvshow.add(
            TVShowEntity(
                6,
                "The Flash",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "2014",
                "77%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"

            ))

        tvshow.add(
            TVShowEntity(
                7,
                "God Friended Me",
                "A self-proclaimed \"pesky atheist\" is encouraged to help strangers by someone claiming to be God who friends him on Facebook.",
                "2018",
                "80%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"

            ))

        tvshow.add(
            TVShowEntity(
                8,
                "Gotham",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                "2014",
                "75%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"

            ))

        tvshow.add(
            TVShowEntity(
                9,
                "Grey\'s Anatomy",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                "2005",
                "82%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
            ))

        tvshow.add(
            TVShowEntity(
                10,
                "Hanna",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                "2019",
                "75%",
                "https://image.tmdb.org/t/p/w500/niw2AKHz6XmwiRMLWaoyAOAti0G.jpg"
        ))

        return tvshow
    }
}