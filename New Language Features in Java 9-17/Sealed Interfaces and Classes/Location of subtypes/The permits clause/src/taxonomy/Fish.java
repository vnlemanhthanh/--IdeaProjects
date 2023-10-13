package taxonomy;


public sealed interface Fish extends Vertebrate permits BonyFish, CartilaginousFish, JawlessFish {

}
