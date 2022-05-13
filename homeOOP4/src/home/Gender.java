package home;

public enum Gender {
Man,
Woman;
	static Gender getTypeByOrdinal(int gend) {
		 for(Gender g : Gender.values()) {
	            if(g.ordinal() == gend) {
	                return g;
	            }
	        }
		return null;
	}
}