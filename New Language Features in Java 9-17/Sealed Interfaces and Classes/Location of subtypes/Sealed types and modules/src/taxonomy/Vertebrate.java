package taxonomy;

import taxonomy.fish.Fish;
import taxonomy.mammal.Mammal;

public sealed interface Vertebrate permits Fish, Amphibian, Reptile, Bird, Mammal {

}
