public class Artist {
  private String m_name;
  
  public Artist(){
    m_name = "unknown";
  }

  public Artist(String name){
    m_name = name;
  }

  public String getName(){
    return m_name;
  }

  public String toString(){
    String s = "";
    s += "\nArtist Name: " + m_name;
    return s;
  }
}
