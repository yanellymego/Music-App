import java.util.LinkedList;

public class Listener {
  private String m_name;
  private LinkedList<Content> m_favorites;

  public Listener(String name){
    m_name = name;
    m_favorites = new LinkedList<Content>();
  }

  public void favorites(Content item){
    m_favorites.add(item);
  }

  public String toString(){
    String s = "";
    s += "\nAccount Name: " + m_name;
    s += "\nFavorites: ";
    for (int i = 0; i < m_favorites.size(); i++){
      if (m_favorites.get(i) == m_favorites.getLast()){
        s += m_favorites.get(i).getName();
      } else {
        s += m_favorites.get(i).getName() + ", ";
      }
    }
    return s;
  }
}
