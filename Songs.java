import java.util.ArrayList;
import java.util.Collections;

public class Songs extends Content implements Comparable<Songs> {
  public Songs(){
    super();
  }

  public Songs(String title, Artist name, String[] genre, int numStream){
    super(title, name, genre, numStream);
  }

  public Songs(String title, Artist name, String[] genre){
    super(title, name, genre, 0);
  }

  public void play(){
    super.play();
  }

  public String toString(){
    String s = "";
    s += super.toString();
    return s;
  }

  public int compareTo(Songs s){
    int ret;
    if (this.m_numOfStreams > s.m_numOfStreams){
      ret = 1;
    } else if (this.m_numOfStreams < s.m_numOfStreams){
      ret = -1;
    } else {
      ret = 0;
    }
    return ret;
  }
}
