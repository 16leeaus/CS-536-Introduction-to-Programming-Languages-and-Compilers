// --== CS536 Project 1 File Header ==--
// Name: <Austin Lee>
// CSL Username: <austinl>
// Email: <alee88@wisc.edu>

public class Sym {

    // Symbol type
    private String type;

    /**
     * Symbol object constructor.
     * 
     * @param type Type of symbol in the sym table.
     */
    public Sym(String type) {
        this.type = type;
    }

    /**
     * This method will return the type of the symbol entry.
     * 
     * @return Symbol type
     */
    public String getType() {
        return type;
    }

    /**
     * This method will return the string representation of the symbol entry.
     */
    public String toString() {
        return type;
    }
}