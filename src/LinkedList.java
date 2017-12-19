
public class LinkedList{
    /* Insere o objeto no fim da lista. */
	private No head = null;
	private No tail = null;

	private static void print(LinkedList lista) {
        No iter = lista.getFirst();
        while (iter != null) {
            System.out.println(iter.getData());
            iter = iter.next();
        }
        System.out.println("---------");
    }
	//insere na ultima posicao 
		public void append(Object object) {
			No node = new No(object);
			if(tail == null){
				head = node;
			}else{
				tail.setNext(node);
				node.setPrevious(tail);
			}
			tail = node;
		}
    /* Insere o objeto no inicio da lista. */
    public void addFirst(Pokemon o){
    	No node = new No(o);
		if(head == null){
			tail = node;
		}else{
			head.setPrevious(node);
			node.setNext(head);
		}
		head = node;
    }
    /* Remove o objeto da lista. */
    public void remove(Pokemon o){
    	if (head == null) {
			throw new IllegalStateException("Erro no REMOVE - HEAD - NULL");
		}
    	No iterador = head;
        while (iterador != null) {
        	if(iterador.getData().equals(o)){
        		iterador.remove();
        		break;
        	}
        	iterador = iterador.next();
        }
        if(o.equals(tail.getData())){
        	tail = tail.previous();
        }
        if(o.equals(head.getData())){
        	head = head.next();
        }
    }
    /* Recupera o primeiro No da lista. */
    public No getFirst(){
    	if (head == null){
    		throw new NullPointerException("ERROR FIRST");
    	}	
    	return head;
    }
    /* Recupera o ultimo No da lista. */
    public No getLast(){
    	if (tail == null){
    		throw new NullPointerException("ERROR LAST");
    	}	
    	return tail;
    }
    /* Testa se o objeto existe na lista. */
    public boolean hasObject(Pokemon o){
    	No iterador = head;
        while (iterador != null) {
        	if(iterador.equals(o)){
        		return true;
        	}
        	iterador = iterador.next();
        }
        return false;
    }
}