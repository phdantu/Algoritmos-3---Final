import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Run {
	static Pokemon poke;
	static Pokemon poke2 = new Pokemon(101,"Togepi",30,"Opportunist",5);
	static BinarySearchTree pokedexTree = new BinarySearchTree();
	static BinarySearchTree atkTree = new BinarySearchTree();
	//public static LinkedList lista = new LinkedList();
    static int pokedex = 15, atk = 30;
    static int min = 15, max = 50;
	//Categorias      insert
	//0 - pokedex  || 0 - by pokedex
	//1 - atk Base || 1 - by atk
	public static void main(String[] args) throws DuplicateKeyException {
		CSVReader();
		
		System.out.println("NUMERO DA POKEDEX  - "+ pokedex);
		pokedexTree.findOnTree(pokedex,0);
		System.out.println();
		
		//System.out.println();;
		//lista.append();
		//print(lista);
		System.out.println("VALOR DE ATK  - "+ atk);
		atkTree.findOnTree(atk,1);
		System.out.println();
		
		System.out.println("BUSCA NA POKEDEX POR RANGE NOS VALORES  - "+ min +" "+ max);
		pokedexTree.findOnTreeByRange(min,max);
		System.out.println();
		//atkTree.print();
		
		
	}
	
	public static void CSVReader() throws DuplicateKeyException{
		try{
			Scanner arq = new Scanner(new File("src/data/pokemon.csv"));
			String linha = null;
			while(arq.hasNext()){
				linha = arq.nextLine();	
				//System.out.println(linha);
				String[] temp = linha.split (Pattern.quote(","));// separa a linha pelas virgulas
				if(temp[0] != null){
					poke  = new Pokemon(Integer.parseInt(temp[0]), temp[1],Integer.parseInt(temp[2]),temp[3],Integer.parseInt(temp[4]));
					pokedexTree.insert(poke,0);
					atkTree.insert(poke,1);
				}
				if(!arq.hasNext()){
					arq.close();
					return;
				}
			}
			//fecha o arquivo
			arq.close();
		}catch (IOException ioe) {
			System.err.printf("Erro na abertura do arquivo: %s.\n",
					ioe.getMessage());
		}
	}
	
}
