import java.util.LinkedList;
import java.util.Random;
import java.util.Collections;

public class Playlist implements Collection, Comparable<Playlist>{
  private String m_title;
  private LinkedList<Content> m_list;

  public Playlist(String name){
    m_title = name;
    m_list = new LinkedList<Content>();
  }

  public String getName(){
    return m_title;
  }

  public int size(){
    return m_list.size();
  }

  public void add(Content c){
    m_list.add(c);
  }
  
  public void remove(Content c){
    m_list.remove(c);
  }

  public void shuffle(){
    Random randy = new Random();
    int playNum = randy.nextInt(m_list.size());
    m_list.get(playNum).play();
  }

  public String toString(){
    String s = "";
    s += "\n" + m_title + ": ";
    if (m_list.size() > 0){
      for (int i = 0; i < m_list.size(); i++){
        if (m_list.get(i) == m_list.getLast()){
          s += m_list.get(i).getName();
        } else {
          s += m_list.get(i).getName() + ", ";
        }
      }
    }
    return s;
  }

  public int compareTo(Playlist p){
    int ret;
    if (this.m_list.size() > p.m_list.size()){
      ret = 1;
    } else if (this.m_list.size() < p.m_list.size()){
      ret = -1;
    } else {
      ret = 0;
    }
    return ret;
  }

}
