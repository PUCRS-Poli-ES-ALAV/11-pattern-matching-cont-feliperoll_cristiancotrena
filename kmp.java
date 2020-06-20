// KMP pattern searching algorithm 

class KMP_String_Matching { 

    public static int instrucoes = 0;
    public static int iteracoes = 0;

    public void main(String args[]){
        System.out.println("Numero de instrucoes  " + instrucoes);
        System.out.println("Numero de iteracoes  " + iteracoes);

    }

	void KMPSearch(String pat, String txt) 
	{ 
		int M = pat.length(); 
		int N = txt.length(); 

        instrucoes = instrucoes + 6;
		// cria lps[] que vai guardar o maior 
		// valor prefixo sufixo para o padrão 
		int lps[] = new int[M]; 
        int j = 0; // index for pat[] 
        instrucoes = instrucoes + 4;

		// Calcula lps[] 
		computeLPSArray(pat, M, lps); 

        int i = 0; // index for txt[] 
        instrucoes = instrucoes + 2;
		while (i < N) { 
            instrucoes = instrucoes + 4;
            iteracoes = iteracoes + 1;
			if (pat.charAt(j) == txt.charAt(i)) { 
				j++; 
                i++; 
                instrucoes = instrucoes + 4;
            } 
            instrucoes = instrucoes + 1;
			if (j == M) { 
				System.out.println("Found pattern "
								+ "at index " + (i - j)); 
                j = lps[j - 1]; 
                instrucoes = instrucoes + 2;
			} 

			// mismatch após j matches 
			else if (i < N && pat.charAt(j) != txt.charAt(i)) { 
				// Não faz match dos caracteres lps[0..lps[j-1]], 
                // não é necesssário, eles combinarão 
                instrucoes = instrucoes + 3;
				if (j != 0) 
                    j = lps[j - 1]; 
                    
				else
                    i = i + 1; 
                    instrucoes = instrucoes + 10;
			} 
		} 
	} 

	void computeLPSArray(String pat, int M, int lps[]) 
	{ 
		// tamanho do maior prefixo sufixo anterior 
		int len = 0; 
		int i = 1; 
        lps[0] = 0; // lps[0] is always 0 
        instrucoes = instrucoes + 4;

		// loop calcula lps[i] for i = 1 to M-1 
		while (i < M) { 
			if (pat.charAt(i) == pat.charAt(len)) { 
				len++; 
				lps[i] = len; 
                i++; 
                instrucoes = instrucoes + 4;
                iteracoes = iteracoes + 1;
			} 
			else // (pat[i] != pat[len]) 
			{ 
				if (len != 0) { 
					len = lps[len - 1]; 
                } 
               
				else // if (len == 0) 
				{ 
					lps[i] = len; 
                    i++; 
                    instrucoes = instrucoes + 7;
				} 
			} 
		} 
    } 
}