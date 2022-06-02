public class Plano {
    private String codigo;
    private String descricao;
    private Double mensalidade;
    private Integer franquia;
    private Double custoChamada;

    public Plano() {

    }

    public Plano(String codigo, String descricao, Double mensalidade, Integer franquia, Double custoChamada) {
        this.codigo = codigo;
        this.descricao = descricao;
        setMensalidade(mensalidade);
        setFranquia(franquia);
        setCustoChamada(custoChamada);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Double mensalidade) {
        if(mensalidade >= 0)
            this.mensalidade = mensalidade;
    }

    public Integer getFranquia() {
        return franquia;
    }

    public void setFranquia(Integer franquia) {
        if(franquia > 0)
            this.franquia = franquia;
        else
            this.franquia = 0;
    }

    public Double getCustoChamada() {
        return custoChamada;
    }

    public void setCustoChamada(Double custoChamada) {
        if(custoChamada >= 0)
            this.custoChamada = custoChamada;
    }

    @Override
    public String toString() {
        return String.format(
            "\nPlano %s\n|\n|_ Descricao: %s\n|\n|_ Mensalidade: R$%.2f\n|\n|_ Franquia: %d\n|\n|_ Custo chamada: R$%.2f",
            codigo, descricao, mensalidade, franquia, custoChamada
        );
    }
}
