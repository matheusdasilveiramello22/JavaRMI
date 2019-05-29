
import com.sun.management.OperatingSystemMXBean;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.rmi.*;
import java.rmi.server.*;
import java.util.logging.Logger;

public class LookerRemote extends UnicastRemoteObject implements Looker {

  LookerRemote() throws RemoteException {
    super();
  }

  public String pcInformation() {
    System.out.println("Processando a requisição do cliente...");
    Recursos r = new Recursos();
    return r.toString();
  }

  class Recursos {

    private long memoriaVirtual, memoriaLivre, memoriaSwapLivre,
            memoriaTotal, memoriaSwapTotal;
    private double tempoCPU, cargaCPUProcesso, cargaCPUSistema,
            cargaSistemaMedia;
    private int numProcessadores;
    private String arquitetura, nomeSO, versao;

    public Recursos() {
      OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
      memoriaVirtual = osmxb.getCommittedVirtualMemorySize();
      memoriaLivre = osmxb.getFreePhysicalMemorySize();
      memoriaSwapLivre = osmxb.getFreeSwapSpaceSize();
      tempoCPU = osmxb.getProcessCpuTime();
      memoriaTotal = osmxb.getTotalPhysicalMemorySize();
      memoriaSwapTotal = osmxb.getTotalSwapSpaceSize();
      arquitetura = osmxb.getArch();
      numProcessadores = osmxb.getAvailableProcessors();
      nomeSO = osmxb.getName();
      cargaCPUProcesso = osmxb.getProcessCpuLoad();
      cargaCPUSistema = osmxb.getSystemCpuLoad();
      cargaSistemaMedia = osmxb.getSystemLoadAverage();
      versao = osmxb.getVersion();
    }
    private final Logger LOG = Logger.getLogger(Recursos.class.getName());

    public long getMemoriaVirtual() {
      return memoriaVirtual;
    }

    public void setMemoriaVirtual(long memoriaVirtual) {
      this.memoriaVirtual = memoriaVirtual;
    }

    public long getMemoriaLivre() {
      return memoriaLivre;
    }

    public void setMemoriaLivre(long memoriaLivre) {
      this.memoriaLivre = memoriaLivre;
    }

    public long getMemoriaSwapLivre() {
      return memoriaSwapLivre;
    }

    public void setMemoriaSwapLivre(long memoriaSwapLivre) {
      this.memoriaSwapLivre = memoriaSwapLivre;
    }

    public long getMemoriaTotal() {
      return memoriaTotal;
    }

    public void setMemoriaTotal(long memoriaTotal) {
      this.memoriaTotal = memoriaTotal;
    }

    public long getMemoriaSwapTotal() {
      return memoriaSwapTotal;
    }

    public void setMemoriaSwapTotal(long memoriaSwapTotal) {
      this.memoriaSwapTotal = memoriaSwapTotal;
    }

    public double getTempoCPU() {
      return tempoCPU;
    }

    public void setTempoCPU(double tempoCPU) {
      this.tempoCPU = tempoCPU;
    }

    public double getCargaCPUProcesso() {
      return cargaCPUProcesso;
    }

    public void setCargaCPUProcesso(double cargaCPUProcesso) {
      this.cargaCPUProcesso = cargaCPUProcesso;
    }

    public double getCargaCPUSistema() {
      return cargaCPUSistema;
    }

    public void setCargaCPUSistema(double cargaCPUSistema) {
      this.cargaCPUSistema = cargaCPUSistema;
    }

    public double getCargaSistemaMedia() {
      return cargaSistemaMedia;
    }

    public void setCargaSistemaMedia(double cargaSistemaMedia) {
      this.cargaSistemaMedia = cargaSistemaMedia;
    }

    public int getNumProcessadores() {
      return numProcessadores;
    }

    public void setNumProcessadores(int numProcessadores) {
      this.numProcessadores = numProcessadores;
    }

    public String getArquitetura() {
      return arquitetura;
    }

    public void setArquitetura(String arquitetura) {
      this.arquitetura = arquitetura;
    }

    public String getNomeSO() {
      return nomeSO;
    }

    public void setNomeSO(String nomeSO) {
      this.nomeSO = nomeSO;
    }

    public String getVersao() {
      return versao;
    }

    public void setVersao(String versao) {
      this.versao = versao;
    }

    @Override
    public String toString() {
      File[] roots = File.listRoots();
    String computerInformation = null;
    for (File root : roots) {
      computerInformation = "\n\t\tRaiz do sistema de arquivos:" + root.getAbsolutePath()
              + "\n\t\tEspaço total (bytes):" + root.getTotalSpace()
              + "\n\t\tEspaço livre (bytes):" + root.getFreeSpace()
              + "\n\t\tEspaço utilizável (bytes):" + root.getUsableSpace();
    }
    
      return "Recursos {" + "\n\t\tmemoriaVirtual=" + memoriaVirtual + "\n\t\tmemoriaLivre=" + memoriaLivre + "\n\t\tmemoriaSwapLivre=" + memoriaSwapLivre + "\n\t\tmemoriaTotal=" + memoriaTotal + "\n\t\tmemoriaSwapTotal=" + memoriaSwapTotal + "\n\t\ttempoCPU=" + tempoCPU + "\n\t\tcargaCPUProcesso=" + cargaCPUProcesso + "\n\t\tcargaCPUSistema=" + cargaCPUSistema + "\n\t\tcargaSistemaMedia=" + cargaSistemaMedia + "\n\t\tnumProcessadores=" + numProcessadores + "\n\t\tarquitetura=" + arquitetura + "\n\t\tnomeSO=" + nomeSO + "\n\t\tversao=" + versao + computerInformation + "\n}";
    }

  }

}
