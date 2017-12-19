
class No{
  public final Object dado;
  private No prox;
  private No anter;
	
    /* Cria um novo no. */
    public No(Object object){
		this.dado = object;
		this.prox = null;
		this.anter = null;
    }
    /* Testa se existe um No apos esse no. */
    public boolean hasNext(){
		if(prox != null){
			return true;
		}
    	return false;
    }
    /* Testa se existe um No antes desse no. */
    public boolean hasPrevious(){
    	if(anter != null){
			return true;
		}
    	return false;
    }
    /* Retorna o pr�ximo No. */
    public No next(){
    	return prox;
    }
    /* Retorna o No anterior. */
    public No previous(){
    	return anter;
    }
    public void setNext(No prox){
    	this.prox = prox;
    }
    public void setPrevious(No anter){
    	this.anter = anter;
    }
    /* Insere um No ap�s esse no. */
       public void insertAfter(Pokemon novo){
    	No node = new No(novo);
		if(node == null){
			throw new IllegalStateException("Erro");
		}
		if(hasPrevious()){
			anter.setNext(prox);
		}
		if(hasNext()){
			prox.setPrevious(anter);
		}
    }
    /* Insere um No antes desse no. */
    public void insertBefore(Pokemon novo){
    	No node = new No(novo);
		if(node == null){
			throw new IllegalStateException("Erro");
		}
		if(hasPrevious()){
			anter.setNext(prox);
		}
		if(hasNext()){
			prox.setPrevious(anter);
		}
    }
    /* Remove o no */
    public void remove(){
    	if(hasPrevious()){
    		anter.setNext(prox);
    	}
    	if(hasNext()){
    		prox.setPrevious(anter);
    	}
    }
    /* Recupera o dado armazenado. */
    public Object getData(){
		return dado;
    }
}