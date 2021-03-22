package com.example.movie_review_app.constants;

public enum Crew {

    TROY_CAST(new String[]{"Brian Cox as Agamemnon", "Brad Pitt as Achilles", "Eric Bana as Hector",
            "Orlando Bloom as Paris  ", "Siri Svegler as Polydora", "Julian Glover as Triopas"}),

    AVATAR_CAST(new String[]{"Sam Worthington as Jake Sully", "Sigourney Weaver as Dr. Grace Augustine",
            "Stephen Lang as Colonel Miles Quaritch", "Michelle Rodriguez as Trudy Chacón",
            "Giovanni Ribisi as Parker Selfridge", "Joel David Moore as Norm Spellman "}),

    TAKEN_CAST(new String[]{"Liam Neeson as Bryan Mills", "Maggie Grace as Kim", "Jon Gries as Casey",
            "Leland Orser as Sam", "Famke Janssen as Lenore"}),

    MORTAL_KOMBAT_CAST(new String[]{"Jessica McNamee as Sonya Blade", "Hiroyuki Sanada as Hanzo Hasashi / " +
            "Scorpion", "Josh Lawson as Kano", "Joe Taslim as Bi-Han / Sub-Zero", "Ludi Lin as Liu Kang",
            "Tadanobu Asano as Raiden", "Mehcad Brooks as Major Jackson \'Jax\' Briggs", "Chin Han as Shang Tsung" }),

    BAD_BOYS_CAST(new String[]{"Martin Lawrence as Marcus Burnett", "Will Smith as Mike Lowrey",
            "Emmanuel Xuereb as Eddie Dominguez", "Lisa Boyle as Girl Decoy", "Frank John Hughes as Casper"})
    ;

    Crew(String[] actors) {
        this.actors = actors;
    }

    private final String[] actors;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (String actor : actors) {
             result.append(actor).append("\n");
        }
        return result.toString();
    }
}
