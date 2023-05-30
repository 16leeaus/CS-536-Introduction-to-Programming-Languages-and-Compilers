import java.util.Iterator;
import java.util.LinkedList;

public class TSym {
    private String type;
    private String kind;

    public TSym(String type) {
        this.type = type;
    }
    public TSym(String type,String kind) {
        this.type = type;
        this.kind = kind;
    }

    public String getType() {
        return type;
    }
    public String getKind() {
        return kind;
    }
    public String toString() {
        return type;
    }


    public SymTable DeclListNode(SymTable ST ) {
        //Iterator it = myDecls.iterator();
        try {
        int x = 1;
        } catch (Exception ex) {
            System.err.println("unexpected NoSuchElementException in DeclListNode.print");
            System.exit(-1);
        }
        return null;
    }
    public void VarSym(SymTable ST, TSym sym ) {
        try{
            if(sym!=null&&ST.lookupLocal(sym.getType())== null){
                ErrMsg.fatal(0, 0, type);
                return;
            }
        }catch (EmptySymTableException e){

        }
        try {
            ST.addDecl(type, sym);
        } catch (DuplicateSymException e) {
            // Throw exception

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

class FnSym extends TSym {
    private LinkedList<String> pTypes;
    private String rType;
    public FnSym(String returnType, LinkedList<String> paramTypes) {
        super("function");
        this.pTypes = paramTypes;
        this.rType = returnType;
    }
  
    public int getNumParams(){
        return pTypes.size();
    }
    
    public String toString() {
        String params ="";
        boolean first = true;
        for (String str:pTypes){
            if(first){
                first = false;
            }else{
                params = params+", ";
            }
            params = params+str;
        }
        return params + " -> " + rType;
    }
  }
