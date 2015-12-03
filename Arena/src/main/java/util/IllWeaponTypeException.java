package util;

public class IllWeaponTypeException extends Exception {

    public IllWeaponTypeException(String msg ){
        super( msg );
    }

    public IllWeaponTypeException(String msg, Exception e ){
        super( msg, e );
    }
}
