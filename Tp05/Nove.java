import java.util.Scanner;

class ArvoreBinaria {
    private No raiz; // Raiz da arvore.

    /**
     * Construtor da classe.
     */
    public ArvoreBinaria() {
        raiz = null;
    }

    /**
     * Metodo publico iterativo para pesquisar elemento.
     * 
     * @param x Elemento que sera procurado.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    public boolean pesquisar(char x) {
        return pesquisar(x, raiz);
    }

    /**
     * Metodo privado recursivo para pesquisar elemento.
     * 
     * @param x Elemento que sera procurado.
     * @param i No em analise.
     * @return <code>true</code> se o elemento existir,
     *         <code>false</code> em caso contrario.
     */
    private boolean pesquisar(char x, No i) {
        boolean resp;
        if (i == null) {
            resp = false;

        } else if (x == i.elemento) {
            resp = true;

        } else if (x < i.elemento) {
            resp = pesquisar(x, i.esq);

        } else {
            resp = pesquisar(x, i.dir);
        }
        return resp;
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharCentral() {
        caminharCentral(raiz);
        System.out.print("\n");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharCentral(No i) {
        if (i != null) {
            caminharCentral(i.esq); // Elementos da esquerda.
            System.out.print(i.elemento + " "); // Conteudo do no.
            caminharCentral(i.dir); // Elementos da direita.
        }
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPre() {
        caminharPre(raiz);
        System.out.print("\n");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharPre(No i) {
        if (i != null) {
            System.out.print(i.elemento + " "); // Conteudo do no.
            caminharPre(i.esq); // Elementos da esquerda.
            caminharPre(i.dir); // Elementos da direita.
        }
    }

    /**
     * Metodo publico iterativo para exibir elementos.
     */
    public void caminharPos() {
        caminharPos(raiz);
        System.out.print("\n");
    }

    /**
     * Metodo privado recursivo para exibir elementos.
     * 
     * @param i No em analise.
     */
    private void caminharPos(No i) {
        if (i != null) {
            caminharPos(i.esq); // Elementos da esquerda.
            caminharPos(i.dir); // Elementos da direita.
            System.out.print(i.elemento + " "); // Conteudo do no.
        }
    }

    /**
     * Metodo publico iterativo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @ Se o elemento existir.
     */
    public void inserir(char x) {
        raiz = inserir(x, raiz);
    }

    /**
     * Metodo privado recursivo para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @ Se o elemento existir.
     */
    private No inserir(char x, No i) {
        if (i == null) {
            i = new No(x);

        } else if (x < i.elemento) {
            i.esq = inserir(x, i.esq);

        } else if (x > i.elemento) {
            i.dir = inserir(x, i.dir);

        } else {
            System.out.println("Erro ao inserir!");
        }

        return i;
    }

    /**
     * Metodo publico para inserir elemento.
     * 
     * @param x Elemento a ser inserido.
     * @ Se o elemento existir.
     */
    public void inserirPai(char x) {
        if (raiz == null) {
            raiz = new No(x);
        } else if (x < raiz.elemento) {
            inserirPai(x, raiz.esq, raiz);
        } else if (x > raiz.elemento) {
            inserirPai(x, raiz.dir, raiz);
        } else {
            System.out.println("Erro ao inserirPai!");
        }
    }

    /**
     * Metodo privado recursivo para inserirPai elemento.
     * 
     * @param x   Elemento a ser inserido.
     * @param i   No em analise.
     * @param pai No superior ao em analise.
     * @ Se o elemento existir.
     */
    private void inserirPai(char x, No i, No pai) {
        if (i == null) {
            if (x < pai.elemento) {
                pai.esq = new No(x);
            } else {
                pai.dir = new No(x);
            }
        } else if (x < i.elemento) {
            inserirPai(x, i.esq, i);
        } else if (x > i.elemento) {
            inserirPai(x, i.dir, i);
        } else {
            System.out.println("Erro ao inserirPai!");
        }
    }

    /**
     * Metodo publico iterativo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @ Se nao encontrar elemento.
     */
    public void remover(char x) {
        raiz = remover(x, raiz);
    }

    /**
     * Metodo privado recursivo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @param i No em analise.
     * @return No em analise, alterado ou nao.
     * @ Se nao encontrar elemento.
     */
    private No remover(char x, No i) {

        if (i == null) {
            System.out.println("Erro ao remover!");

        } else if (x < i.elemento) {
            i.esq = remover(x, i.esq);

        } else if (x > i.elemento) {
            i.dir = remover(x, i.dir);

            // Sem no a direita.
        } else if (i.dir == null) {
            i = i.esq;

            // Sem no a esquerda.
        } else if (i.esq == null) {
            i = i.dir;

            // No a esquerda e no a direita.
        } else {
            i.esq = maiorEsq(i, i.esq);
        }

        return i;
    }

    /**
     * Metodo para trocar o elemento "removido" pelo maior da esquerda.
     * 
     * @param i No que teve o elemento removido.
     * @param j No da subarvore esquerda.
     * @return No em analise, alterado ou nao.
     */
    private No maiorEsq(No i, No j) {

        // Encontrou o maximo da subarvore esquerda.
        if (j.dir == null) {
            i.elemento = j.elemento; // Substitui i por j.
            j = j.esq; // Substitui j por j.ESQ.

            // Existe no a direita.
        } else {
            // Caminha para direita.
            j.dir = maiorEsq(i, j.dir);
        }
        return j;
    }

    /**
     * Metodo que retorna o maior elemento da árvore
     * 
     * @return int maior elemento da árvore
     */
    public int getMaior() {
        int resp = -1;

        if (raiz != null) {
            No i;
            for (i = raiz; i.dir != null; i = i.dir)
                ;
            resp = i.elemento;
        }

        return resp;
    }

    /**
     * Metodo que retorna o menor elemento da árvore
     * 
     * @return int menor elemento da árvore
     */
    public int getMenor() {
        int resp = -1;

        if (raiz != null) {
            No i;
            for (i = raiz; i.esq != null; i = i.esq)
                ;
            resp = i.elemento;
        }

        return resp;
    }

    /**
     * Metodo que retorna a altura da árvore
     * 
     * @return int altura da árvore
     */
    public int getAltura() {
        return getAltura(raiz, 0);
    }

    /**
     * Metodo que retorna a altura da árvore
     * 
     * @return int altura da árvore
     */
    public int getAltura(No i, int altura) {
        if (i == null) {
            altura--;
        } else {
            int alturaEsq = getAltura(i.esq, altura + 1);
            int alturaDir = getAltura(i.dir, altura + 1);
            altura = (alturaEsq > alturaDir) ? alturaEsq : alturaDir;
        }
        return altura;
    }

    /**
     * Metodo publico iterativo para remover elemento.
     * 
     * @param x Elemento a ser removido.
     * @ Se nao encontrar elemento.
     */
    public void remover2(char x) {
        if (raiz == null) {
            System.out.println("Erro ao remover2!");
        } else if (x < raiz.elemento) {
            remover2(x, raiz.esq, raiz);
        } else if (x > raiz.elemento) {
            remover2(x, raiz.dir, raiz);
        } else if (raiz.dir == null) {
            raiz = raiz.esq;
        } else if (raiz.esq == null) {
            raiz = raiz.dir;
        } else {
            raiz.esq = maiorEsq(raiz, raiz.esq);
        }
    }

    /**
     * Metodo privado recursivo para remover elemento.
     * 
     * @param x   Elemento a ser removido.
     * @param i   No em analise.
     * @param pai do No em analise.
     * @ Se nao encontrar elemento.
     */
    private void remover2(char x, No i, No pai) {
        if (i == null) {
            System.out.println("Erro ao remover2!");
        } else if (x < i.elemento) {
            remover2(x, i.esq, i);
        } else if (x > i.elemento) {
            remover2(x, i.dir, i);
        } else if (i.dir == null) {
            pai = i.esq;
        } else if (i.esq == null) {
            pai = i.dir;
        } else {
            i.esq = maiorEsq(i, i.esq);
        }
    }

    public int getRaiz() {
        return raiz.elemento;
    }

    public static boolean igual(ArvoreBinaria a1, ArvoreBinaria a2) {
        return igual(a1.raiz, a2.raiz);
    }

    private static boolean igual(No i1, No i2) {
        boolean resp;
        if (i1 != null && i2 != null) {
            resp = (i1.elemento == i2.elemento) && igual(i1.esq, i2.esq) && igual(i1.dir, i2.dir);
        } else if (i1 == null && i2 == null) {
            resp = true;
        } else {
            resp = false;
        }
        return resp;
    }

    public int soma() {
        return soma(raiz);
    }

    public int soma(No i) {
        int resp = 0;
        if (i != null) {
            resp = i.elemento + soma(i.esq) + soma(i.dir);
        }
        return resp;
    }

    public int quantidadePares() {
        return quantidadePares(raiz);
    }

    public int quantidadePares(No i) {
        int resp = 0;
        if (i != null) {
            resp = ((i.elemento % 2 == 0) ? 1 : 0) + quantidadePares(i.esq) + quantidadePares(i.dir);
        }
        return resp;
    }

    public boolean hasDiv11() {
        return hasDiv11(raiz);
    }

    public boolean hasDiv11(No i) {
        boolean resp = false;
        if (i != null) {
            resp = (i.elemento % 11 == 0) || hasDiv11(i.esq) || hasDiv11(i.dir);
        }
        return resp;
    }
}

/**
 * No da arvore binaria
 * 
 * @author Max do Val Machado
 */

class No {
    public char elemento; // Conteudo do no.
    public No esq, dir; // Filhos da esq e dir.

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     */
    public No(char elemento) {
        this(elemento, null, null);
    }

    /**
     * Construtor da classe.
     * 
     * @param elemento Conteudo do no.
     * @param esq      No da esquerda.
     * @param dir      No da direita.
     */
    public No(char elemento, No esq, No dir) {
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

public class Nove {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char palavra;
        ArvoreBinaria avinha = new ArvoreBinaria();
        while (in.hasNext()) {
            String comand = in.next();
            if (comand.equals("I")) {
                palavra = in.next().charAt(0);
                avinha.inserir(palavra);
            } else if (comand.equals("P")) {
                palavra = in.next().charAt(0);
                if (avinha.pesquisar(palavra)) {
                    System.out.println(palavra + " existe");
                } else {
                    System.out.println("nao existe");
                }
            } else if (comand.equals("INFIXA")) {
                avinha.caminharCentral();
            } else if (comand.equals("PREFIXA")) {
                avinha.caminharPre();
            } else if (comand.equals("POSFIXA")) {
                avinha.caminharPos();
            }
        }
        
        in.close();
    }
}