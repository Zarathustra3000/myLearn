import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Loader {
    public static void main(String[] args) {
        String text = "Raskolnikov had a fearful dream. He dreamt he was back in his childhood in the little town of his birth. " +
                "He was a child about seven years old, walking into the country with his father on the evening of a holiday. " +
                "It was a grey and heavy day, the country was exactly as he remembered it; indeed he recalled it far more vividly in his dream than he had done in memory. " +
                "The little town stood on a level flat as bare as the hand, not even a willow near it; only in the far distance, a copse lay, a dark blur on the very edge of the horizon. " +
                "A few paces beyond the last market garden stood a tavern, a big tavern, which had always aroused in him a feeling of aversion, even of fear, when he walked by it with his father. " +
                "There was always a crowd there, always shouting, laughter and abuse, hideous hoarse singing and often fighting. " +
                "Drunken and horrible-looking figures were hanging about the tavern. " +
                "He used to cling close to his father, trembling all over when he met them. " +
                "Near the tavern the road became a dusty track, the dust of which was always black. " +
                "It was a winding road, and about a hundred paces further on, it turned to the right to the graveyard. " +
                "In the middle of the graveyard stood a stone church with a green cupola where he used to go to mass two or three times a year with his father and mother, when a service was held in memory of his grandmother, who had long been dead, and whom he had never seen. " +
                "On these occasions they used to take on a white dish tied up in a table napkin a special sort of rice pudding with raisins stuck in it in the shape of a cross. He loved that church, the old-fashioned, unadorned ikons and the old priest with the shaking head. " +
                "Near his grandmother’s grave, which was marked by a stone, was the little grave of his younger brother who had died at six months old. " +
                "He did not remember him at all, but he had been told about his little brother, and whenever he visited the graveyard he used religiously and reverently to cross himself and to bow down and kiss the little grave. " +
                "And now he dreamt that he was walking with his father past the tavern on the way to the graveyard; he was holding his father’s hand and looking with dread at the tavern. " +
                "A peculiar circumstance attracted his attention: there seemed to be some kind of festivity going on, there were crowds of gaily dressed townspeople, peasant women, their husbands, and riff-raff of all sorts, all singing and all more or less drunk. " +
                "Near the entrance of the tavern stood a cart, but a strange cart. It was one of those big carts usually drawn by heavy cart-horses and laden with casks of wine or other heavy goods. " +
                "He always liked looking at those great cart-horses, with their long manes, thick legs, and slow even pace, drawing along a perfect mountain with no appearance of effort, as though it were easier going with a load than without it. " +
                "But now, strange to say, in the shafts of such a cart he saw a thin little sorrel beast, one of those peasants’ nags which he had often seen straining their utmost under a heavy load of wood or hay, especially when the wheels were stuck in the mud or in a rut. " +
                "And the peasants would beat them so cruelly, sometimes even about the nose and eyes, and he felt so sorry, so sorry for them that he almost cried, and his mother always used to take him away from the window. " +
                "All of a sudden there was a great uproar of shouting, singing and the balalaïka, and from the tavern a number of big and very drunken peasants came out, " +
                "wearing red and blue shirts and coats thrown over their shoulders.\n" +
                "\n" +
                "“Get in, get in!” shouted one of them, a young thick-necked peasant with a fleshy face red as a carrot. “I’ll take you all, get in! grandmother’s”";

        Pattern pattern = Pattern.compile("[a-zA-Z[’ï]]+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
