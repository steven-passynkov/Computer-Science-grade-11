/**
 * Exc-6-Shakespeare-Insult-Generator-Part-2 for 10 random combinations
 * Print sentense using adverb, adjective and noun
 * 
 * @author Steven Passynkov (#1058058)
 * @since 23 July 2023
 */
class Shakey {
  /**
   * Print sentense using adverb, adjective and noun
   *
   * @param adverb
   */
  static void printSentence(String adverb, String adjective, String noun) {
    // Thou art prefix
    String prefix = "Thou art";
    // article before adverb
    String article = "a";
    // if the adverb begins with a consonant
    if (adverb.startsWith("a")) {
      article = "an";
    }
    // print sentense
    System.out.printf("%s %s %s, %s, %s!\n", prefix, article, adverb, adjective, noun);
  }

  public static void main(String[] args) {
    // Paste your arrays here again. See codeSnips.md
    String[] adverbs = { "artless", "bawdy", "beslubbering", "bootless", "churlish", "cockered",
        "clouted", "craven", "currish", "dankish", "dissembling", "droning", "errant",
        "fawning", "fobbing", "froward", "frothy", "gleeking", "goatish", "gorbellied",
        "impertinent", "infectious", "jarring", "loggerheaded", "lumpish", "mammering",
        "mangled", "mewling", "paunchy", "pribbling", "puking", "puny", "qualling",
        "rank", "reeky", "rogueish", "ruttish", "saucy", "spleeny", "spongy", "surly",
        "tottering", "unmuzzled", "vain", "venomed", "villainous", "warped", "wayward",
        "weedy", "yeastly" };

    String[] adjectives = { "base-court", "bat-fowling", "beef-witted", "beetle-headed",
        "boil-brained", "clapper-clawed", "clay-brained", "common-kissing", "crook-pated",
        "dismal-dreaming", "dizzy-eyed", "doghearted", "dread-bolted", "earth-vexing",
        "elf-skinned", "fat-kidneyed", "fen-sucked", "flap-mouthed", "fly-bitten",
        "folly-fallen", "fool-born", "full-gorged", "guts-griping", "half-faced",
        "hasty-witted", "hedge-born", "hell-hated", "idle-headed", "ill-breeding",
        "ill-nurtured", "knotty-pated", "milk-livered", "motley-minded", "onion-eyed",
        "plume-plucked", "pottle-deep", "pox-marked", "reeling-ripe", "rough-hewn",
        "rude-growing", "rump-fed", "shard-borne", "sheep-biting", "spur-galled",
        "swag-bellied", "tardy-gaited", "tickle-brained", "toad-spotted", "unchin-snouted",
        "weather-bitten" };

    String[] nouns = { "apple-john", "baggage", "barnacle", "bladder", "boar-pig", "bugbear",
        "bum-bailey", "canker-blossom", "clack-dish", "clotpole", "coxcomb", "codpiece",
        "death-token", "dewberry", "flap-dragon", "flax-wench", "flirt-gill", "foot-licker",
        "fustilarian", "giglet", "gudgeon", "haggard", "harpy", "hedge-pig", "horn-beast",
        "hugger-mugger", "joithead", "lewdster", "lout", "maggot-pie", "malt-worm", "mammet",
        "measle", "minnow", "miscreant", "moldwarp", "mumble-news", "nut-hook", "pidgeon-egg",
        "pignut", "puttock", "pumpion", "ratsbane", "scut", "skainsmate", "strumpet", "varlot",
        "vassal", "whey-face", "wagtail" };

    // Part 2:
    // Write out 10 random insults, consisting of one word from each array, chosen
    // at random.
    // codeSnips has a suggestion for how you can generate a random array element.
    // This time, you need to write it in the form:
    // Thou art an adverb, adjective, noun! (if the adverb begins with a vowel) or:
    // Thou art a adverb, adjective, noun! (if the adverb begins with a consonant).
    // adverb adjective noun
    // Use a loop and an IF statement, and please also consider spacing and
    // punctuation.

    int adverbsLength = adverbs.length;
    int adjectivesLength = adjectives.length;
    int nounsLength = nouns.length;

    for (int i = 0; i < 10; i++) {
      int randomAdverbIdx = (int) (Math.random() * (adverbsLength - 1));
      int randomAdjectiveIdx = (int) (Math.random() * (adjectivesLength - 1));
      int randomNounIdx = (int) (Math.random() * (nounsLength - 1));
      printSentence(adverbs[randomAdverbIdx], adjectives[randomAdjectiveIdx], nouns[randomNounIdx]);
    }
  }
}