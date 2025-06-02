import java.util.ArrayList;
import java.util.Collections;

public class Podcast extends Content implements Comparable<Podcast> {
  private int m_episodeNum;

  public Podcast(){
    super();
    m_episodeNum = 0;
  }

  public Podcast(String title, Artist name, String[] genre, int numStream, int episode){
    super(title, name, genre, numStream);
    m_episodeNum = episode;
  }

  public void play(){
    super.play();
  }

  public String toString(){
    String s = "";
    s += "\nEpisode: " + m_episodeNum;
    s += super.toString();
    return s;
  }

  public int compareTo(Podcast p){
    int ret;
    if (this.m_numOfStreams > p.m_numOfStreams){
      ret = 1;
    } else if (this.m_numOfStreams < p.m_numOfStreams){
      ret = -1;
    } else {
      ret = 0;
    }
    return ret;
  }
}
