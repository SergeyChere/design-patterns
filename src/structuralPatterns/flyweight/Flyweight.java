package structuralPatterns.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Flyweight {

    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree(11, 22, "oak", "green", "rough");
        forest.plantTree(11, 22, "oak", "green", "rough");
        forest.plantTree(11, 22, "oak", "green", "rough");
        forest.plantTree(11, 22, "oak", "green", "rough");
        forest.plantTree(11, 22, "oak", "green", "rough");
        forest.draw();
    }

    /*
    Tree and forest
     */

    public static class Forest {
        List<Tree> trees = new ArrayList<>();

        public void plantTree(int x, int y, String name, String color, String texture) {
            TreeType type = TreeTypeFactory.getTreeType(name, color, texture);
            Tree tree = new Tree(x, y, type);
            trees.add(tree);
        }

        public void draw() {
            for (Tree tree : trees) {
                tree.draw();
            }
        }
    }

    public static class Tree {
        private int x;
        private int y;
        private TreeType tree;

        public Tree(int x, int y, TreeType tree) {
            this.x=x;
            this.y=y;
            this.tree=tree;
        }

        public void draw() {
            tree.drawCanvas(x, y);
        }
    }

    /*
    Tree type and tree factory
     */

    public static class TreeTypeFactory {
        private static List<TreeType> trees = new ArrayList<>();

        private static TreeType getTreeType(String name, String color, String texture) {
            TreeType type = new TreeType();
            if (trees.isEmpty()) {
                type = new TreeType(name, color, texture);
                trees.add(type);
                return type;
            }
            for (TreeType treeType : trees) {
                if (treeType.name.equals(name) && treeType.color.equals(color) && treeType.texture.equals(texture)) {
                    type = treeType;
                }
            }
            if (type == null) {
                type = new TreeType(name, color, texture);
                trees.add(type);
            }
            return type;
        }
    }

    public static class TreeType {
        private String name;
        private String color;
        private String texture;

        public TreeType() {}

        public TreeType(String name, String color, String texture) {
            this.name=name;
            this.color=color;
            this.texture=texture;
        }

        public void drawCanvas(int x, int y) {
            System.out.println("Tree type: "+x+", "+y+", "+name+", "+color+", "+texture);
        }
    }
}
