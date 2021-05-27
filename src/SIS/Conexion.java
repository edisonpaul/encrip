/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package SIS;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Analista
 */
public class Conexion
{
    static Connection conexion;
    static Statement sentencia;
    static String usuario;
    static String nombreUsuario;
    static String emailUsuario;
    static String password;
    static java.sql.Date fechaIngreso;
    static String horaIngreso;
    static String ip;
    static String codigoAuditoria;
    static String rutaReportes;
    static String rutaReportesImagenGrande;
    static String rutaReportesImagenPequenia;
    static String rutaAyuda;
    static String rutaEnviables;
    
    static String urlConexion;
  
    
        
    File archivo=null;
    FileReader archivoLeido=null;
    BufferedReader bufferLeido = null;

    public static String getUrlConexion() {
        return urlConexion;
    }

    public static void setUrlConexion(String urlConexion) {
        Conexion.urlConexion = urlConexion;
    }

    
    
    public static String getEmailUsuario() {
        return emailUsuario;
    }

    public static void setEmailUsuario(String emailUsuario) {
        Conexion.emailUsuario = emailUsuario;
    }
        
    public static String getRutaEnviables() {
        return rutaEnviables;
    }

    public static void setRutaEnviables(String rutaEnviables) {
        Conexion.rutaEnviables = rutaEnviables;
    }
    
    
    public String getRutaAyuda() {
        return rutaAyuda;
    }

    public void setRutaAyuda(String rutaAyuda) {
        Conexion.rutaAyuda = rutaAyuda;
    }

       
    public String getRutaReportesImagenGrande() {
        return rutaReportesImagenGrande;
    }

    public void setRutaReportesImagenGrande(String rutaReportesImagenGrande) {
        Conexion.rutaReportesImagenGrande = rutaReportesImagenGrande;
    }

    public String getRutaReportesImagenPequenia() {
        return rutaReportesImagenPequenia;
    }

    public void setRutaReportesImagenPequenia(String rutaReportesImagenPequenia) {
        Conexion.rutaReportesImagenPequenia = rutaReportesImagenPequenia;
    }
        

     public  String getRutaReportes() {
        return rutaReportes;
    }

    public  void setRutaReportes(String rutaReportes) {
        Conexion.rutaReportes = rutaReportes;
    }
    
    
    public static String getCodigoAuditoria() {
        return codigoAuditoria;
    }

    public static void setCodigoAuditoria(String codigoAuditoria) {
        Conexion.codigoAuditoria = codigoAuditoria;
    }

    
    
    public static String getHoraIngreso() {
        return horaIngreso;
    }

    public static void setHoraIngreso(String horaIngreso) {
        Conexion.horaIngreso = horaIngreso;
    }
        
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

        

    ///Conexion
    public Connection getConexion()
    {
        return conexion;
    }

    public void setConexion(Connection conexionEntrada)
    {
        conexion=conexionEntrada;
    }

    ///Sentencia
     public Statement getSentencia()
    {
        return sentencia;
    }

    public void setSentencia(Statement sentenciaEntrada)
    {
        sentencia=sentenciaEntrada;
    }

    ///Usuario
     public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuarioEntrada)
    {
        usuario=usuarioEntrada;
    }

    ///Nombre Usuario
    public String getNombreUsuario()
    {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuarioEntrada)
    {
        nombreUsuario=nombreUsuarioEntrada;
    }

    ///Password
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String passwordEntrada)
    {
        password=passwordEntrada;
    }

    public void PrepararBase() throws Exception
    {
        try
        {
            String controlador="com.informix.jdbc.IfxDriver";
            Class.forName(controlador).newInstance();
            
            String DSN=urlConexion;
            
            conexion=DriverManager.getConnection(DSN);
            
        }
        catch(Exception e)
        {
            throw e;
            //JOptionPane.showMessageDialog(null, "Error Controlador");
        }

        
    }
    
    public String LeerArchivo() throws Exception
    {
        String linea=null;
        String url=null;

        try
        {

//         archivo = new File ("smb:///192.168.0.193/Desarrollo/Sistema_Sweaden/ConfiguracionInicial.txt");
//         archivoLeido = new FileReader (archivo);
//         bufferLeido = new BufferedReader(archivoLeido);


//         while((linea=bufferLeido.readLine())!=null)
//         {
            //url=linea;

            //url="jdbc:informix-sqli://192.168.0.86:1526/seguros:INFORMIXSERVER=ol_server;user=sopuio;password=sop555";
            
            //urlConexion="jdbc:informix-sqli://192.168.0.86:1526/seguros:INFORMIXSERVER=ol_server;user=sopuio;password=sop555";
            
            urlConexion="jdbc:informix-sqli://186.5.109.203:1526/seguros:INFORMIXSERVER=ol_server;user=sopuio;password=sop555";
//         }

        }
        catch(Exception e)
        {
            throw e;
        }

        return url;
    }
    
    public ResultSet SeleccionarParametrosGenerales() throws Exception
    {
        ResultSet rparametros=null;
        Statement sparametros=null;
        
        try
        {
            sparametros=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            
            String parametros="SELECT imageng, imagenp, ultimaact "+
                              "FROM sw_parparametrosgenerales";
            
            rparametros=sparametros.executeQuery(parametros);
            
        }
        catch(Exception e)
        {
            throw e;
        }
        
        return rparametros;
    }

}
