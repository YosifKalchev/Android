package com.example.movie_review_app.constants;

public enum Review {

    TROY(" It is the year 1250 B.C. during the late Bronze age. Two emerging nations begin " +
            "to clash after Paris, the Trojan prince, convinces Helen, Queen of Sparta, to leave" +
            " her husband, Menelaus, and sail with him back to Troy. After Menelaus finds out that " +
            "his wife was taken by the Trojans, he asks his brother Agamemnon to help him get her back. " +
            "Agamemnon sees this as an opportunity for power. So they set off with 1,000 ships holding " +
            "50,000 Greeks to Troy. With the help of Achilles, the Greeks are able to fight the never " +
            "before defeated Trojans. But they come to a stop by Hector, Prince of Troy. The whole movie " +
            "shows their battle struggles and the foreshadowing of fate in this adaptation of Homer's " +
            "classic \"The Iliad."),
    AVATAR("When his brother is killed in a robbery, paraplegic Marine Jake Sully decides to take" +
            " his place in a mission on the distant world of Pandora. There he learns of greedy corporate " +
            "figurehead Parker Selfridge's intentions of driving off the native humanoid \"Na'vi\" in " +
            "order to mine for the precious material scattered throughout their rich woodland. In exchange" +
            " for the spinal surgery that will fix his legs, Jake gathers knowledge, of the Indigenous " +
            "Race and their Culture, for the cooperating military unit spearheaded by gung-ho Colonel " +
            "Quaritch, while simultaneously attempting to infiltrate the Na'vi people with the use of " +
            "an \"avatar\" identity. While Jake begins to bond with the native tribe and quickly falls " +
            "in love with the beautiful alien Neytiri, the restless Colonel moves forward with his" +
            " ruthless extermination tactics, forcing the soldier to take a stand - and fight back" +
            " in an epic battle for the fate of Pandora."),
    TAKEN("Former CIA agent Bryan Mills reluctantly agrees to let his 17 year old daughter Kim " +
            "go to Paris on a trip. His ex-wife Lenore and her new husband Stuart are all for it and " +
            "Kim sets off with a friend. On arrival in Paris however, Kim and her friend are kidnapped" +
            " by mobsters running a slavery-prostitution ring. Bryan's only lead is a short snippet " +
            "of a conversation from when Kim phoned him in a panic. With that, he's able to identify " +
            "the origin of the speaker and which criminal gang he's with. Once in Paris, he quickly " +
            "shows everyone connected with the case that he will stop at nothing to get his daughter back."),
    MORTAL_KOMBAT("MMA fighter Cole Young (Lewis Tan), accustomed to taking a beating for money," +
            " is unaware of his heritage-or why Outworld's Emperor Shang Tsung (Chin Han) has sent his " +
            "best warrior, Sub-Zero (Joe Taslim), an otherworldly Cryomancer, to hunt Cole down." +
            " Fearing for his family's safety, Cole goes in search of Sonya Blade (Jessica McNamee) " +
            "at the direction of Jax (Mehcad Brooks), a Special Forces Major who bears the same strange" +
            " dragon marking Cole was born with. Soon, he finds himself at the temple of Lord Raiden " +
            "(Tadanobu Asano), an Elder God and the protector of Earthrealm, who grants sanctuary to " +
            "those who bear the mark. Here, Cole trains with experienced warriors Liu Kang (Ludi Lin)," +
            " Kung Lao (Max Huang) and rogue mercenary Kano (Josh Lawson), as he prepares to stand" +
            " with Earth's greatest champions against the enemies of Outworld in a high stakes battle " +
            "for the universe. But will Cole be pushed hard enough to unlock his arcana-the immense " +
            "power from within his soul-in time to save not only his family but to stop Outworld " +
            "once and for all?"),
    BAD_BOYS("Detectives Mike Lowery and Marcus Brunette have 72 hours to find $100 million" +
            " worth of heroin before Internal Affairs shuts them down. Lowery becomes more involved " +
            "after a friend is murdered by the drug dealers. Matters become complicated when Lowery " +
            "and Brunette have to switch places to convince a witness to the murder to cooperate.")
    ;

    private final String value;

    Review(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
