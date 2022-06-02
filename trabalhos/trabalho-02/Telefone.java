public class Telefone
{
    private String numero;
    private Cliente cliente;
    private Plano plano;
    private Date dataAtivacao;
    private Time horaAtivacao;
    private Date dataCancelamento;
    private Time horaCancelamento;
    private int diaPagamento = 1;
    private final int[] dias = new int[]{1, 5, 10, 15};

    public String getNumero() 
    {
        return this.numero;
    }

    public void setNumero(String numero) 
    {
        this.numero = numero;
    }

    public Cliente getCliente() 
    {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) 
    {
        this.cliente = cliente;
    }

    public Plano getPlano() 
    {
        return this.plano;
    }

    public void setPlano(Plano plano) 
    {
        this.plano = plano;
    }

    public Date getDataAtivacao() 
    {
        return this.dataAtivacao;
    }

    public void setDataAtivacao(Date dataAtivacao) 
    {
        this.dataAtivacao = dataAtivacao;
    }

    public Time getHoraAtivacao() {
        return this.horaAtivacao;
    }

    public void setHoraAtivacao(Time horaAtivacao) 
    {
        this.horaAtivacao = horaAtivacao;
    }

    public Date getDataCancelamento() 
    {
        return this.dataCancelamento;
    }

    public void setDataCancelamento(Date dataCancelamento) 
    {
        this.dataCancelamento = dataCancelamento.occursAfter(dataAtivacao) != -1 ? dataCancelamento : this.dataCancelamento;
    }

    public Time getHoraCancelamento() 
    {
        return this.horaCancelamento;
    }

    public void setHoraCancelamento(Time horaCancelamento) 
    {
        if(dataCancelamento != null)
        {
            if(dataCancelamento.occursAfter(dataAtivacao) == 1 || horaCancelamento.isLaterThan(horaAtivacao) == 1)
                this.horaCancelamento = horaCancelamento;
            else
            {
                this.horaCancelamento = null;
                dataCancelamento = null;
            }
        }
        else
            this.horaCancelamento = null;
    }

    public int getDiaPagamento() 
    {
        return this.diaPagamento;
    }

    public void setDiaPagamento(int diaPagamento) 
    {
        boolean valido = false;
        for(int dia : dias)
        {
            if(diaPagamento == dia)
                valido = true;
        }

        this.diaPagamento = valido ? diaPagamento : this.diaPagamento;
    }

    @Override
    public String toString()
    {
        if(horaCancelamento != null)
        {
            return String.format(
                "+ Telefone: %s\n%s\n%s\n\n+ Data/Hora de Ativacao: %s  %s\n+ Data/Hora de Cancelamento: %s  %s\n+ Dia do pagamento: %d",
                numero, cliente.toString(), plano.toString(), dataAtivacao.toString(), horaAtivacao.toString(), dataCancelamento.toString(),
                horaCancelamento.toString(), diaPagamento
            );
        }
        else
        {
            return String.format(
                "+ Telefone: %s\n%s\n%s\n\n+ Data/Hora de Ativacao: %s  %s\n+ Dia do pagamento: %d",
                numero, cliente.toString(), plano.toString(), dataAtivacao.toString(), horaAtivacao.toString(), diaPagamento
            );
        }
    }
}
