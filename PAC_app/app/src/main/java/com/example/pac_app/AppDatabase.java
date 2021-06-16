package com.example.pac_app;

import android.content.Context;
import android.telecom.Call;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.pac_app.model.Game;
import com.example.pac_app.model.Users;

@Database(entities = {Users.class, Game.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase{

    public abstract UsersDao getUsersDao();
    public abstract GameDao getGameDao();

    public static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "AppDataBase")
                            .allowMainThreadQueries()
                            .addCallback(new Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://lh3.googleusercontent.com/HCUkD69MAHEOj84Yi7Kb5vxHpCeP" +
                                            "TsmQI4g9vYuVPUo-87cWE6ZZIk0tiyYzaiS9zaAFMTXRNYJaaRczRN-yQYw', 'Red Dead Redemption 2', 'America, 1899. The end of the w" +
                                            "ild west era has begun as lawmen hunt down the last remaining outlaw gangs. Those who will not surrender or succumb are killed.\n" +
                                            "\n" +
                                            "After a robbery goes badly wrong in the western town of Blackwater, Arthur Morgan and the Van der Linde gang are " +
                                            "forced to flee. With federal agents and the best bounty hunters in the nation massing on their heels, the gang must rob, steal and " +
                                            "fight their way across the rugged heartland of America in order to survive. As deepening internal divisions threaten to tear the gang apart, " +
                                            "Arthur must make a choice between his own ideals and loyalty to the gang who raised him.', '" + Constants.categoryList.get(0) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://upload.wikimedia.org/wikipedia/pt/7/77/Mass_Effect_-" +
                                            "_Legendary_Edition_-_Capa.jpg', 'Mass Effect Legendary Edition', 'One person is all that stands between humanity " +
                                            "and the greatest threat it’s ever faced. Relive the legend of Commander Shepard in " +
                                            "the highly acclaimed Mass Effect trilogy with the Mass Effect™ Legendary Edition." +
                                            " Includes single-player base content and over 40 DLC from Mass Effect, Mass Effect 2, " +
                                            "and Mass Effect 3 games, including promo weapons, armors and packs — remastered and " +
                                            "optimized for 4K Ultra HD.\n" +
                                            "\n" +
                                            "Experience an amazingly rich and detailed universe where your decisions have profound con" +
                                            "sequences on the action and the outcome.', '" + Constants.categoryList.get(0) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://upload.wikimedia.org/wikipedia/pt/d/d0/Horizon_Zero_Dawn_capa.png'" +
                                            ", 'Horizon Zero Dawn Complete Edition', 'Experience Aloy’s entire legendary quest to unravel " +
                                            "the mysteries of a world ruled by deadly Machines.\n" +
                                            "\n" +
                                            "An outcast from her tribe, the young hunter fights to uncover her past, discover her destiny… and" +
                                            " stop a catastrophic threat to the future.\n" +
                                            "\n" +
                                            "Unleash devastating, tactical attacks against unique Machines and rival tribes as you explore an o" +
                                            "pen world teeming with wildlife and danger.', '" + Constants.categoryList.get(1) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://upload.wikimedia.org/wikipedia/pt/f/f7/Cyberpunk_2077_capa.png'" +
                                            ", 'Cyberpunk 2077', 'Cyberpunk 2077 is an open-world, action-adventure story set in Night City," +
                                            " a megalopolis obsessed with power, glamour and body modification. You play as V, a mercenary" +
                                            " outlaw going after a one-of-a-kind implant that is the key to immortality. You can customize" +
                                            " your character’s cyberware, skillset and playstyle, and explore a vast city where the choices you" +
                                            " make shape the story and the world around you.', '" + Constants.categoryList.get(1) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://image.api.playstation.com/vulcan/ap/rnd/202102/0418/cfbTDvs2m1P9mArX74ClI9HR.png'" +
                                            ", 'BIOMUTANT', 'BIOMUTANT is an open-world, post-apocalyptic Kung-Fu fable " +
                                            "RPG, with a unique martial arts styled combat system allowing you to mix melee, " +
                                            "shooting and mutant ability action.\n" +
                                            "\n" +
                                            "A plague is ruining the land and the Tree-of-Life is bleeding " +
                                            "death from its roots. The Tribes stand divided. Explore a world in " +
                                            "turmoil and define its fate – will you be its saviour or lead it to an " +
                                            "even darker destiny?', '" + Constants.categoryList.get(0) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://cdn-products.eneba.com/resized-products/fbwtoie90jibxgkrf6mx_350x200_1x-0.jpg'" +
                                            ",'The Elder Scrolls V: Skyrim Legendary Edition', 'Winner of more than 200 Game of the Year Awards, " +
                                            "Skyrim Special Edition brings the epic fantasy to life" +
                                            " in stunning detail. The Special Edition includes the critically acclaimed game and add-ons " +
                                            "with all-new features like remastered art and effects, volumetric god rays, dynamic depth of field," +
                                            " screen-space reflections, and more. Skyrim Special Edition also brings the full power of mods to the " +
                                            "PC and consoles. New quests, environments, characters, dialogue, armor, weapons and more – with Mods, there" +
                                            " are no limits to what you can experience.', '" + Constants.categoryList.get(2) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://s2.glbimg.com/2ik4UmZ1jyKN7DDrIEx6M3XiDv0=/1200x/smar" +
                                            "t/filters:cover():strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43" +
                                            "087e7a/internal_photos/bs/2019/e/R/tgvsehSqmc7RmDCdJQcw/daysgone1.jpg'" +
                                            ",'Days Gone', 'Days Gone is an open-world action-adventure game set " +
                                            "in a harsh wilderness two years after a devastating global pandemic.\n" +
                                            "\n" +
                                            "Step into the dirt flecked shoes of former outlaw biker Deacon St. John, a bounty hunter trying to find" +
                                            " a reason to live in a land surrounded by death. Scavenge through abandoned settlements for equipment to craft" +
                                            " valuable items and weapons, or take your chances with other survivors trying to eke out a living through fair tra" +
                                            "de… or more violent means.', '" + Constants.categoryList.get(2) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://upload.wikimedia.org/wikipedia/pt/8/80/Grand_Theft_Auto_V_capa.png'" +
                                            ",'Grand Theft Auto V', 'Grand Theft Auto V for PC will take full advantage of the power of " +
                                            "PC to deliver across-the-board enhancements including increased resolution and graphical detail" +
                                            ", denser traffic, greater draw distances, upgraded AI, new wildlife, and advanced weather and " +
                                            "damage effects for the ultimate open world experience.\n" +
                                            "\n" +
                                            "Grand Theft Auto V for PC features the all-new First Person Mode, " +
                                            "giving players the chance to explore the incredibly detailed world of Los " +
                                            "Santos and Blaine County in an entirely new way across both Story Mode " +
                                            "and Grand Theft Auto Online. ', '" + Constants.categoryList.get(2) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://image.api.playstation.com/cdn/EP0700/CUSA03365_00/gSJkkVfpqk8qEp3fQglGcu3OLbXeHJ1W.png'" +
                                            ",'Dark Souls III Deluxe Edition', 'As fires fade and the world falls into ruin, journey into a universe " +
                                            "filled with more colossal enemies and environments. Players will be immersed into a world of epic atmosphere" +
                                            " and darkness through faster gameplay and amplified combat intensity. Fans and newcomers alike will get lost in " +
                                            "the game hallmark rewarding gameplay and immersive graphics.\n" +
                                            "Now only embers remain… Prepare yourself once more and Embrace The " +
                                            "Darkness!', '" + Constants.categoryList.get(1) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://s2.glbimg.com/sdE4sWtWEwlcKoGnI4QCpaO4Mxc=/0x0:1200x675/984x0/" +
                                            "smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/inter" +
                                            "nal_photos/bs/2019/W/M/dAijS8QXmSGiMKVddvZQ/death-stranding.jpg'" +
                                            ",'Death Stranding', 'From legendary game creator Hideo Kojima comes an all-new, genre-defying experience.\n" +
                                            "\n" +
                                            "Sam Bridges must brave a world utterly transformed by the Death Str" +
                                            "anding. Carrying the disconnected remnants of our future in his hands, he embark" +
                                            "s on a journey to reconnect the shattered world one step at a time.\n" +
                                            "\n" +
                                            "Starring Norman Reedus, Mads Mikkelsen, Léa Seydoux, and Lindsay Wagner. ', " +
                                            "'" + Constants.categoryList.get(2) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://upload.wikimedia.org/wikipedia/pt/1/19/MGS5_TPP.jpg'" +
                                            ", 'Metal Gear Solid V', 'In celebration of the huge success that Metal Gear Solid " +
                                            "5 has achieved, Konami is bundling up everything MSG5 and re-releasing it as Metal" +
                                            " Gear Solid 5: The Definitive Experience. If you haven’t had a chance to experience" +
                                            " the Metal Gear series, or just missed this most recent game, you should not miss this" +
                                            " sweet deal. This game continues the story of the iconic agent Snake. Once again you are" +
                                            " responsible for saving the world from diabolical terrorists bent on gaining power through " +
                                            "destruction. Use stealth, careful planning, and the diverse arsenal of the Diamond Dogs (your m" +
                                            "ercenary crew) to foil your adversaries.', '" + Constants.categoryList.get(1) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://image.api.playstation.com/vulcan/img/rnd/202010/1908/35Fq1N8ZBaOsh2odxMBGvjUj.png'" +
                                            ", 'F1 2020', 'F1® 2020 is the most comprehensive F1® game yet, putting players firmly in the driving seat as " +
                                            "they race against the best drivers in the world. For the first time, players can create their own F1® team " +
                                            "by creating a driver, then choosing a sponsor, an engine supplier, hiring a teammate and competing as the 11th" +
                                            " team on the grid. Build facilities, develop the team over time and drive to the top.', " +
                                            "'" + Constants.categoryList.get(3) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://images-na.ssl-images-amazon.com/images/I/91z7JfyD9%2BL._AC_UL600_SR600,600_.png'" +
                                            ", 'Motorsport Manager', 'Have you got what it takes to become the manager of a high-performance motorsport " +
                                            "team? Motorsport Manager is a highly detailed, best-in-class management game for fans of motorsport. Youll " +
                                            "hire the drivers, build the cars and embed yourself in the dynamic world of racing.\n" +
                                            "\n" +
                                            "Every single detail will need to be considered in order to push your way to the champ" +
                                            "ionship title. Split second decisions on the race track combine with carefully laid pre-race " +
                                            "plans; everything from building and customising your car to race-day tactics will affect your path" +
                                            " to either ultimate victory or epic failure.\n" +
                                            "\n" +
                                            "Stop watching, start winning and take control as the manager of" +
                                            " your own motorsport team.', '" + Constants.categoryList.get(3) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://cdn.cdkeys.com/500x706/media/catalog/product/f/o/football_manager_2021_pc.jpg'" +
                                            ", 'Football Manager 2021', 'The manager is the beating heart of every football club. In Football Manager" +
                                            " 2021 dynamic, true-to-life management experiences and next-level detail renews that focus on you like neve" +
                                            "r before, equipping you with all the tools to achieve elite status.\n" +
                                            "\n" +
                                            "With more than 50 nations and 2,500 clubs at every level of the football pyramid to choose from, the possibil" +
                                            "ities are endless. It’s over to you, boss.', " +
                                            "'" + Constants.categoryList.get(4) + "', 59.99, 0)");

                                    db.execSQL("INSERT INTO Game (id, imgURL, title, description, category, price, isInCart) " +
                                            "VALUES(null, 'https://image.api.playstation.com/cdn/EP4040/CUSA01797_00/NMcAucyANMnYMNkz6V5vk9f5YXty2mCz.png'" +
                                            ", 'Assetto Corsa', 'Assetto Corsa is a next-generation driving simulator for Windows PC which reproduces real-" +
                                            "world circuits, as well as road and racing cars. The game includes a single player career" +
                                            ",special events and allows the player to create and customize offline competitions and mu" +
                                            "ltiplayer races to challenge other players. ', " +
                                            "'" + Constants.categoryList.get(4) + "', 59.99, 0)");

                                }
                            })
                            .build();
        }
        return INSTANCE;
    }
}
