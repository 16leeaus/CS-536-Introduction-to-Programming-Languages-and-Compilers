// --== CS536 Project 1 File Header ==--
// Name: <Austin Lee>
// CSL Username: <austinl>
// Email: <alee88@wisc.edu>

import java.util.*;

public class SymTable {

    /**
     * The SymTable's linkedlist that contains the different scopes of the
     * program.
     */
    private List<HashMap<String, Sym>> symTable = new LinkedList<>();

    /**
     * SymTable constructor, will initialize the SymTable's list with a single
     * empty HashMap.
     */
    public SymTable() {
        symTable.add(new HashMap<>());
    }

    /**
     * Adds a new declaration to the currently active SymTable. Check for any
     * issues such as empty table, duplicate entries, or null parameters, throw
     * any applicable exceptions. Otherwise, declare a symbol in the table.
     * 
     * @param name The name of the symbol for declaration.
     * @param sym  The Sym for declaration.
     * @throws DuplicateSymException    Thrown if the hashmap already contains a
     *                                  key with the given name.
     * @throws EmptySymTableException   Thrown if the SymTable's list is empty.
     * @throws IllegalArgumentException Thrown if the name or the Sym passed in
     *                                  are null.
     */
    public void addDecl(String name, Sym sym) throws DuplicateSymException,
            EmptySymTableException {

        if (symTable.isEmpty()) {
            throw new EmptySymTableException();
        }

        if (name == null || sym == null) {
            throw new IllegalArgumentException();
        }

        if (symTable.get(0).containsKey(name)) {
            throw new DuplicateSymException();
        }

        symTable.get(0).put(name, sym);
    }

    /**
     * Add a new scope to the sym table list.
     */
    public void addScope() {
        symTable.add(0, new HashMap<>());
    }

    /**
     * Method used to check if a symbol name exists in a local scope. If the
     * table is empty, throw an exception. If the symbol exists in the table, it
     * will be returned. Otherwise null is the default return value.
     * 
     * @param name Name of the symbol to lookup.
     * @return
     * @throws EmptySymTableException Thrown if the sym table does not contain a
     *                                scope to search.
     */
    public Sym lookupLocal(String name) throws EmptySymTableException {
        if (symTable.isEmpty()) {
            throw new EmptySymTableException();
        }

        return symTable.get(0).getOrDefault(name, null);
    }

    /**
     * Method used to check if a symbol exists globally, on any existing scope.
     * If the table is empty throw an exception. Otherwise, iterate through all
     * of the available Hashmaps, if the symbol exists it is returned. Otherwise
     * the default return is null.
     * 
     * @param name Name of the symbol to lookup.
     * @return
     * @throws EmptySymTableException Thrown if the symbol table does not
     *                                contain a scope to search.
     */
    public Sym lookupGlobal(String name) throws EmptySymTableException {
        if (symTable.isEmpty()) {
            throw new EmptySymTableException();
        }

        for (HashMap<String, Sym> map : symTable) {
            if (map.containsKey(name)) {
                return map.get(name);
            }
        }

        return null;
    }

    /**
     * Remove the current local scope from the symbol table.
     * 
     * @throws EmptySymTableException Thrown if the sym table does not contain a
     *                                scope to remove.
     */
    public void removeScope() throws EmptySymTableException {
        if (symTable.isEmpty()) {
            throw new EmptySymTableException();
        }

        symTable.remove(0);
    }

    /**
     * Print method for debugging purposes, and to check the validity of the
     * program. Will be run in the P1.java program, and prints out the contents
     * of the sym table. Using System.out.print, this method will print the
     * contents of each scope in the sym table.
     */
    public void print() {
        System.out.print("\nSym Table\n");
        for (HashMap<String, Sym> map : symTable)
            System.out.println(map);
        System.out.println();
    }
}