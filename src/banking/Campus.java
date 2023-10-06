package banking;

public enum Campus {
    NEW_BRUNSWICK(0), NEWARK(1),CAMDEN(2);

private int code;


Campus(int code){
        this.code=code;
    }
public int getCode(){
        return code;
    }


}

