public abstract class Content{
  protected String m_title;
  protected Artist m_artist;
  protected String[] m_genre;
  protected int m_numOfStreams;

  public Content(){
    m_title = "";
    m_artist = new Artist();
    m_genre = new String[3];
    m_numOfStreams = 0;
  }

  public Content(String title, Artist name, String[] genre, int numStream){
    m_title = title;
    m_artist = name;
    m_genre = genre;
    m_numOfStreams = numStream;
  }

  public void play(){
    System.out.println("\nCurrently playing: " + m_title);
    m_numOfStreams ++;
  }

  public String getName(){
    return m_title;
  }

  public String toString(){
    String s = "";
    s += "\nTitle: " + m_title;
    s += "\nArtist: " + m_artist.getName();
    s += "\nGenre(s): ";
    for (int i = 0; i < m_genre.length; i++){
      if (m_genre[i] != null){
        if (m_genre[i] == m_genre[m_genre.length - 1]){
          s += m_genre[i];
        } else {
          s += m_genre[i] + ", ";
        }
      }
    }
    s += "\nStreamed: " + m_numOfStreams + " times";
    return s;
  }
}
