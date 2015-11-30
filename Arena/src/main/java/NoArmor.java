public class NoArmor extends Armor {

        private static NoArmor Instance = new NoArmor( "", 0 );

        private NoArmor( String name, int defenceDamage ){
            super( name, defenceDamage );
        }

        @Override
        public String useArmor(){
            return "";
        }

        public static NoArmor getInstance() {
            return Instance;
        }
}
