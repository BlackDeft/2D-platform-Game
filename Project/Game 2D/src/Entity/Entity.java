package Entity;
import java.awt.Graphics;
import java.awt.Rectangle;
import main.Handler;
public abstract class Entity {
	
	protected float x, y;
	protected Handler handler;
	protected int width, height;
	public Rectangle bounds;
	
	public Entity(Handler handler,float x,float y, int width,int height ) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		
		bounds = new Rectangle(0 ,0 , width, height);
		}
	public boolean isSolid() {
		return true;
	}
	 public abstract void tick();
	 
	 public boolean checkEntityCollisions(float xOffset,float yOffset) {
		 for(Entity e : handler.getWorld().getEntityManager().getEntities()) {
			 if(e.equals((this)) )
			 {
				 continue;
			 }
					 
			 if(!e.isSolid())
			 {
				 continue;
			 }
				 
			 if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset,yOffset))) {
				 e.doOnTouch();
				 return true;
			 }
			}
		 
		 return false;
	 }
	 
	 protected void doOnTouch() {
	}
	 
	public Rectangle getCollisionBounds(float xOffset,float yOffset) {
		 return new Rectangle(( int ) (x + bounds.x + xOffset),( int ) ( y+bounds.y+yOffset ),bounds.width,bounds.height);
	 }
	 public abstract void render(Graphics g);

		public float getX() {
			return x;
		}

		public void setX(float x) {
			this.x = x;
		}

		public float getY() {
			return y;
		}

		public void setY(float y) {
			this.y = y;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

}
