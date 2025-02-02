/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour
 */

public class ListArrayOfPalavra {

    // Atributos
    private static final int INITIAL_SIZE = 10;
    private Palavra[] data;
    private int count;
    private int numeroOcorrencias = 0;

    /**
     * Construtor da lista.
     */
    public ListArrayOfPalavra() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayOfPalavra(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Palavra[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() { // O(1)
        data = new Palavra[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size() { // O(1)
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Palavra element) { // O(n)
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra get(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }
    public String getWord(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index].getPalavra();
    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra set(int index, Palavra element) { // O(1)
        if ((index < 0) || (index >= size())) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        Palavra aux = data[index];
        data[index] = element;
        return aux;
    }    

    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
     * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Palavra element) { // O(n)
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false; // Neste ponto, não achou, retorna falso
    }

    public boolean containsString(Palavra element) { // O(n)
        String auxiliar = element.getPalavra();
        for (int i = 0; i < count; i++) {
            if (data[i].getPalavra().equals(auxiliar)) {
                return true;
            }
        }
        return false; // Neste ponto, não achou, retorna falso
    }
    
    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Palavra[] newData = new Palavra[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }
  
    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Palavra element) { // O(n)
        if (index<0 || index>count){
            throw new IndexOutOfBoundsException(); 
        }
        
        if (count == data.length) 
            setCapacity(data.length * 2); 
        
        for(int i = count; i>index; i--)
            data[i] = data[i-1];
        
        data[index] = element;
        count++;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Palavra element) { // O(n)
        for(int i=0; i<count; i++) {
            if(element.equals(data[i])) {
                for(int j=i; j<count-1; j++)
                    data[j] = data[j+1];
                data[count-1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
    public boolean removePalavra(String element) { // O(n)
        String aux = element;
        for(int i=0; i<count; i++) {
            if(aux.equals(data[i].getPalavra())) {
                for(int j=i; j<count-1; j++)
                    data[j] = data[j+1];
                data[count-1] = null;
                count--;
                return true;
            }
        }
        return false;
    }
        
    /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Palavra removeByIndex(int index) { // O(n)
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Palavra aux = data[index];
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        data[count - 1] = null;
        count--;
        return aux;
    }
   
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Palavra element) { // O(n)
        // Procura elemento no array, se achar retorna o índice
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        // Neste ponto, não achou: retorna -1
        return -1;
    }

    

    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
     * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */    
    public boolean containsRecursivo(Palavra element) { // O(n)
        return containsRecursivoAux(element, 0);
    }    
    private boolean containsRecursivoAux(Palavra element, int i) {
        if (i>=count)
            return false;
        else if (data[i].equals(element))
            return true;
        else
            return containsRecursivoAux(element, i+1);
    }
    
    /**
     * Retorna um arranjo que contem os elementos da lista original entre 
     * fromIndex (inclusivo) e toIndex (exclusivo).
     * @param fromIndex posicao a partir da qual os elementos serao inseridos no
     * arranjo a ser retornado
     * @param toIndex indica a posicao final dos elementos que devem ser inseridos
     * @return Um arranjo com um subconjunto dos elementos da lista.
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */   
    public Palavra[] subList (int fromIndex , int toIndex) { // O(n)
        if (fromIndex < 0 || toIndex > size())
            throw new IndexOutOfBoundsException();
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();
        Palavra [] aux = new Palavra[toIndex-fromIndex];
        for(int i=fromIndex, j=0; i<toIndex; i++, j++) {
            aux[j] = data[i];
        }
        return aux;
    }

    public int getNumeroOcorrencias() {
        return numeroOcorrencias;
    }

    public void setNumeroOcorrencias() {
        numeroOcorrencias += 1;
    }
    
}
