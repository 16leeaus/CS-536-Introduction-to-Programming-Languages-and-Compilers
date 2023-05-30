
public class P1 {

    public static void main(String[] args) {
        testSym();
        testSymTable();
        testAddScope();
        testLocalLookup();
        testGlobalLookup();
        testRemoveScope();
        testPrint();
    }

    private static void testSym() {
        // Test Sym constructor:
        try {
            Sym sym = new Sym("Test");
        } catch (Exception e) {
            System.out.println("Exception thrown duing Sym construction!");
        }

        // Test sym getType Method:
        try {
            Sym testSym = new Sym("Test");
            if (!testSym.getType().equals("Test")) {
                System.out.println("Incorrect sym type returned!");
            }
        } catch (Exception e) {
            System.out.println("Exception thrown duing Sym construction!");
        }

        // Test Sym toString method:
        try {
            Sym testSym = new Sym("Test");
            if (!testSym.toString().equals("Test")) {
                System.out.println("Incorrect sym type returned!");
            }
        } catch (Exception e) {
            System.out.println("Exception thrown duing Sym construction!");
        }
    }

    // Private holding function used to store references to the sym table tests:
    private static void testSymTable() {
        testSymTableConstructor();
        testAddDecNormal();
        testSymTableEmptyWithDec();
        testSymTableNullParam();
        testAddDuplicateSym();
    }

    // Test the symTable constructor:
    private static void testSymTableConstructor() {
        try {
            SymTable symTable = new SymTable();
        } catch (Exception e) {
            System.out.println("Exception thrown during sym table constructor");
        }
    }

    // Test symTable declaration under normal circumstances:
    private static void testAddDecNormal() {
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("testSym", new Sym("test"));
        } catch (Exception e) {
            System.out.println("testAddDecNormal: Exception " + e + " was thrown!");
        }

    }

    // Test add declaration with empty scope:
    private static void testSymTableEmptyWithDec() {
        try {
            SymTable symTable = new SymTable();
            symTable.removeScope();
            symTable.addDecl("testSym", new Sym("test"));

        } catch (Exception e) {
            System.out.println("testSymTableEmptyWithDec: Exception: " + e + " was thrown!");
        }
    }

    // Test add declaration with all three types of null parameters:
    private static void testSymTableNullParam() {
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl(null, new Sym("test"));
        } catch (Exception e) {
            System.out.println("testSymTableNullParam: Exception: Name was null");
        }

        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("Test", new Sym(null));
        } catch (Exception e) {
            System.out.println("testSymTableNullParam: Exception: Both name and sym are null");
        }

        try {
            SymTable symTable = new SymTable();
            symTable.addDecl(null, new Sym(null));
        } catch (Exception e) {
            System.out.println("testSymTableNullParam: Exception: Both name and sym are null");
        }
    }

    // Test add decaration with a duplicate symbol:
    private static void testAddDuplicateSym() {
        SymTable symTable = new SymTable();
        try {
            symTable.addDecl("testSym", new Sym("test"));
            symTable.addDecl("testSym", new Sym("test"));
        } catch (DuplicateSymException | EmptySymTableException e) {
            e.printStackTrace();
        }
    }

    // Test the add scope method, no exceptions should be thrown.
    private static void testAddScope() {
        try {
            SymTable symTable = new SymTable();
            symTable.addScope();
            symTable.addScope();
        } catch (Exception e) {
            System.out.println("Exception " + e + "was called during testAddScope.");
        }
    }

    // Test the local lookup method:
    private static void testLocalLookup() {
        try {
            SymTable symTable = new SymTable();
            symTable.removeScope();
            symTable.lookupLocal("testSym");
        } catch (Exception e) {
            System.out.println("testLocalLookup: " + e + "was thrown.");
        }

        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("testSym", new Sym("test"));
            Sym sym = symTable.lookupLocal("testSym");
            System.out.println("testLocalLookup: " + "Test passed");
        } catch (Exception e) {
            System.out.println("testLocalLookup: " + e + "was thrown.");
        }

        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("testSym", new Sym("test"));
            if (symTable.lookupLocal("test") == null) {
                System.out.println("testLocalLookup: passed, null was returned for a unfound sym.");
            }
        } catch (Exception e) {
            System.out.println("testLocalLookup: " + e + "was thrown.");
        }
    }

    private static void testGlobalLookup() {

    }

    // Test the remove scope method. If the table is empty, then a
    // EmptySymTableException will be thrown.
    private static void testRemoveScope() {
        try {
            System.out.println("testRemoveScope Normal operation:");
            SymTable symTable = new SymTable();
            symTable.removeScope();
        } catch (EmptySymTableException e) {
            System.out.println("Exception " + e + "was called during testRemoveScope.");
        } catch (Exception e) {
            System.out.println("Exception " + e + "was called during testRemoveScope.");
        }
        try {
            System.out.println("testRemoveScope exception operation:");
            SymTable symTable = new SymTable();
            symTable.removeScope();
            symTable.removeScope();
        } catch (EmptySymTableException e) {
            System.out.println("Exception " + e + "was called during testRemoveScope.");
        } catch (Exception e) {
            System.out.println("Exception " + e + "was called during testRemoveScope.");
        }
    }

    // Test the sym table print method, however no exception should be thrown.
    private static void testPrint() {
        try {
            SymTable symTable = new SymTable();
            symTable.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}