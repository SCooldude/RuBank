package banking;

public enum Campus {
    NEW_BRUNSWICK(0), NEWARK(1),CAMDEN(2);

private final int collegeCode;


Campus(int code){
        this.collegeCode =code;
    }
public int getCollegeCode(){
        return collegeCode;
    }


}

