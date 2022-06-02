import java.time.LocalDateTime;

public class Chamada
{
    private Telefone numeroOrigem;
    private String numeroDestino;
    private Date dataInicio;
    private Time horaInicio;
    private Date dataFim;
    private Time horaFim;
    private double custo;
    private int alem;
    private int franquiaOriginal;

    public Telefone getNumeroOrigem()
    {
        return this.numeroOrigem;
    }

    public void setNumeroOrigem(Telefone numeroOrigem)
    {
        this.numeroOrigem = numeroOrigem;
        franquiaOriginal = this.numeroOrigem.getPlano().getFranquia();
    }

    public void reset()
    {
        numeroOrigem.getPlano().setFranquia(franquiaOriginal);
    }

    public String getNumeroDestino() 
    {
        return this.numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) 
    {
        this.numeroDestino = numeroDestino;
    }

    public Date getDataInicio() 
    {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) 
    {
        this.dataInicio = dataInicio;
    }

    public Time getHoraInicio() 
    {
        return this.horaInicio;
    }

    public void setHoraInicio(Time horaInicio) 
    {
        this.horaInicio = horaInicio;
    }

    public Date getDataFim() 
    {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) 
    {
        this.dataFim = dataFim.occursAfter(dataInicio) != -1 ? dataFim : this.dataFim;
    }

    public Time getHoraFim() 
    {
        return this.horaFim;
    }

    public void setHoraFim(Time horaFim) 
    {
        if(dataFim != null)
        {
            if(dataFim.occursAfter(dataInicio) == 1 || horaFim.isLaterThan(horaInicio) == 1)
                this.horaFim = horaFim;
            else
            {
                this.horaFim = null;
                dataFim = null;
            }
        }
        else
            this.horaFim = null;
    }

    public double getCusto()
    {
        return custo;
    }
    
    public int getAlem()
    {
        return alem;
    }

    @Override
    public String toString()
    {
        int minutos = (horaFim.getHour() - horaInicio.getHour()) * 60 + horaFim.getMinute() - horaInicio.getMinute();
        alem = minutos - numeroOrigem.getPlano().getFranquia();
        if(alem < 0)
            alem = 0;
        custo = alem * numeroOrigem.getPlano().getCustoChamada();

        numeroOrigem.getPlano().setFranquia(numeroOrigem.getPlano().getFranquia() - minutos);

        return String.format(
            "\n- Numero de origem: %s\n- Numero de destino: %s\n- Data/Hora de inicio: %s %s\n- Data/Hora de fim: %s %s\n- Duracao total em minutos: %d\n- Custo: %.2f",
            numeroOrigem.getNumero(), numeroDestino, dataInicio.toString(), horaInicio.toString(), dataFim.toString(), horaFim.toString(), minutos, custo
        );
    }
}
