package util;

public class IllUseWeaponException extends Exception{

    public IllUseWeaponException(String msg ){
        super( msg );
    }

    public IllUseWeaponException(String msg, Exception e ){
        super( msg, e );
    }
}
