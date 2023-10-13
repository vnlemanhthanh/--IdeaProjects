package taxonomy.fish;


import taxonomy.Vertebrate;
import taxonomy.fish.BonyFish;
import taxonomy.fish.CartilaginousFish;
import taxonomy.fish.JawlessFish;

public sealed interface Fish extends Vertebrate permits BonyFish, CartilaginousFish, JawlessFish {

}
