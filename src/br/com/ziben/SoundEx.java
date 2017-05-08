package br.com.ziben;

/**
 * Verify if words have the same sound, one sound severals writing
 * @author ccardozo
 *
 */
public class SoundEx {

	/**
	 * Metodo que retorna um valor para determinadas letras
	 * @param inChar
	 * @return
	 */
	public char soundexValue ( char inChar) {
		char foundValue = '0';
	
		switch (inChar) {
		case 'B': case 'F':  case 'P':  case 'V': 		
			foundValue = '1';
			break;
		case 'C': case 'G': case 'J': case 'K': 
		case 'Q': case 'S': case 'X': case 'Z': case 'Ç':
			foundValue = '2';
			break;
		case 'D': case 'T':
			foundValue = '3';
			break;
		case 'L':
			foundValue = '4';
			break;
		case 'M': case 'N':
			foundValue = '5';
			break;
		case 'R':
			foundValue = '6';
			break;
		}
		return foundValue;
	}
	
	public String getSoundex( String strGetSound) {
		// defensive programming... hehe
		if(strGetSound == null)
			return "SHIT";
		// will store the result
		String result = null;
		// soundex is case sensitive
		String strSoundUpper = strGetSound.toUpperCase();
		// contains the word... I dont believe that exists a word >50 (german?)
		char theResult[]  = new char[50];
		// mark the letters that doenst matter to algorithm
		boolean notMatter = false;
		// store the index from results
		int k = 0;
		// the first letter is copyied on results
		theResult[k] = strSoundUpper.charAt(0);
		// I'll need from the first char
		char valueFirstChar = theResult[0];
		// store the return value of the letter sound
		char valueOfSound = '0';
		// if the code > 4 chars, the rest dont matter
		// if < 4 will be filled by zeros (and leave the algorithm)
		for (int i = 1; i < strSoundUpper.length(); i++) {
			// The vowels A,E,I,O,U the characters Y,W e H and the
			// others characters cannot be considereted
			notMatter = false;
			switch (strSoundUpper.charAt(i)) {
			case 'A': case 'E': case 'I': case 'O': 
			case 'U': case 'Y': case 'W': case 'H':
				notMatter = true;
				break;
			}
			// looping
			if(notMatter) continue;
			
			// take the sound letter value
			valueOfSound = soundexValue(strSoundUpper.charAt(i));
			if(valueOfSound != '0' && valueFirstChar != valueOfSound) {
				k++;
				theResult[k] = valueOfSound;
			}
			valueFirstChar = valueOfSound;
			valueOfSound = '0';
		}
		
		// if the word < 4 bytes, fill with zeros
		// to avoid wasting time; now handle the worst case
		result = String.valueOf(theResult).trim() + "0000";
		// limit the size to 4 bytes
		result = result.substring(0, 4);
		
		return result;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SoundEx sound = new SoundEx();
		
		//System.out.println("-->" + sound.getSoundex("SOUNDEXLMX"));
		//System.out.println("-->" + sound.getSoundex("SO"));
		System.out.println("-->" + sound.getSoundex("CISSA"));
		System.out.println("-->" + sound.getSoundex("CIÇA"));
		System.out.println("-->" + sound.getSoundex("CICA"));
		System.out.println("-->" + sound.getSoundex("CISA"));
		
		System.out.println("-------------------------------------");
		
		System.out.println("-->" + sound.getSoundex("PISCINA"));
		System.out.println("-->" + sound.getSoundex("PISSINA"));
		System.out.println("-->" + sound.getSoundex("PICINA"));
		System.out.println("-->" + sound.getSoundex("PIÇINA"));	
		
		System.out.println("-------------------------------------");
		
		System.out.println("-->" + sound.getSoundex("EXCETO"));
		System.out.println("-->" + sound.getSoundex("ESSETO"));
		System.out.println("-->" + sound.getSoundex("EÇETO"));
		System.out.println("-->" + sound.getSoundex("ESETO"));	
		
		System.out.println("-------------------------------------");
		
		System.out.println("-->" + sound.getSoundex("SEXO"));
		System.out.println("-->" + sound.getSoundex("SECSO"));
		System.out.println("-->" + sound.getSoundex("SEKSO"));
		
		System.out.println("-------------------------------------");		
		
		System.out.println("-->" + sound.getSoundex("JOÃO"));
		System.out.println("-->" + sound.getSoundex("JUÃO"));		
		System.out.println("-->" + sound.getSoundex("JOAO"));
		
		System.out.println("-------------------------------------");		
		
		System.out.println("-->" + sound.getSoundex("BECHMAN"));
		System.out.println("-->" + sound.getSoundex("BEKMAN"));		
		System.out.println("-->" + sound.getSoundex("BECMAN"));		
				
		System.out.println("-------------------------------------");		
		
		System.out.println("-->" + sound.getSoundex("TÓXICO"));
		System.out.println("-->" + sound.getSoundex("TOXICO"));		
		System.out.println("-->" + sound.getSoundex("TOCSICO"));			
		System.out.println("-->" + sound.getSoundex("TOCSICU"));
		
		System.out.println("-------------------------------------");
		
		System.out.println("-->" + sound.getSoundex("ELIZABETH"));
		System.out.println("-->" + sound.getSoundex("ELIZABETE"));
		System.out.println("-->" + sound.getSoundex("ELISABETH"));
		System.out.println("-->" + sound.getSoundex("ELISABETE"));
		
	}

}
