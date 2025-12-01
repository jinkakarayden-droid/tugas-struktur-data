import java.util.*;

public class GraphSearch {
    
    // Kelas untuk merepresentasikan Graf
    static class Graph {
        private Map<String, List<String>> adjacencyList;
        private Map<String, Integer> nodeValues;
        
        public Graph() {
            adjacencyList = new HashMap<>();
            nodeValues = new HashMap<>();
        }
        
        // Menambahkan node dengan nilai
        public void addNode(String node, int value) {
            adjacencyList.putIfAbsent(node, new ArrayList<>());
            nodeValues.put(node, value);
        }
        
        // Menambahkan edge (hubungan antar node)
        public void addEdge(String source, String destination) {
            adjacencyList.get(source).add(destination);
        }
        
        // Mendapatkan nilai node
        public int getNodeValue(String node) {
            return nodeValues.getOrDefault(node, -1);
        }
        
        // Mendapatkan tetangga node
        public List<String> getNeighbors(String node) {
            return adjacencyList.getOrDefault(node, new ArrayList<>());
        }
        
        // Menampilkan struktur graf
        public void displayGraph() {
            System.out.println("\n=== STRUKTUR GRAF ===");
            for (String node : adjacencyList.keySet()) {
                System.out.print(node + " (nilai: " + nodeValues.get(node) + ") -> ");
                System.out.println(adjacencyList.get(node));
            }
        }
    }
    
    // ==================== DEPTH-FIRST SEARCH (DFS) ====================
    
    public static String dfsSearch(Graph graph, String startNode, int target) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║     PENCARIAN DENGAN DEPTH-FIRST SEARCH (DFS)  ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Target yang dicari: " + target);
        System.out.println("Node awal: " + startNode + "\n");
        
        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();
        List<String> searchPath = new ArrayList<>();
        
        stack.push(startNode);
        int step = 1;
        
        System.out.println("--- PROSES PENCARIAN DFS ---\n");
        
        while (!stack.isEmpty()) {
            String currentNode = stack.pop();
            
            if (visited.contains(currentNode)) {
                continue;
            }
            
            visited.add(currentNode);
            searchPath.add(currentNode);
            int currentValue = graph.getNodeValue(currentNode);
            
            System.out.println("Langkah " + step + ":");
            System.out.println("  • Node dikunjungi: " + currentNode);
            System.out.println("  • Nilai node: " + currentValue);
            System.out.println("  • Stack saat ini: " + stack);
            System.out.println("  • Visited: " + visited);
            
            // Cek apakah nilai node sama dengan target
            if (currentValue == target) {
                System.out.println("\n✓ TARGET DITEMUKAN!");
                System.out.println("  Node: " + currentNode);
                System.out.println("  Nilai: " + currentValue);
                System.out.println("  Path pencarian: " + searchPath);
                return currentNode;
            }
            
            // Tambahkan tetangga ke stack (dalam urutan terbalik agar DFS sesuai)
            List<String> neighbors = graph.getNeighbors(currentNode);
            System.out.println("  • Tetangga: " + neighbors);
            
            // Push tetangga dalam urutan terbalik
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                String neighbor = neighbors.get(i);
                if (!visited.contains(neighbor)) {
                    stack.push(neighbor);
                }
            }
            
            System.out.println("  • Stack setelah push: " + stack);
            System.out.println();
            step++;
        }
        
        System.out.println("✗ Target tidak ditemukan dalam graf");
        System.out.println("Path pencarian: " + searchPath);
        return null;
    }
    
    // ==================== BREADTH-FIRST SEARCH (BFS) ====================
    
    public static String bfsSearch(Graph graph, String startNode, int target) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   PENCARIAN DENGAN BREADTH-FIRST SEARCH (BFS)  ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Target yang dicari: " + target);
        System.out.println("Node awal: " + startNode + "\n");
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        List<String> searchPath = new ArrayList<>();
        
        queue.offer(startNode);
        visited.add(startNode);
        int step = 1;
        
        System.out.println("--- PROSES PENCARIAN BFS ---\n");
        
        while (!queue.isEmpty()) {
            String currentNode = queue.poll();
            searchPath.add(currentNode);
            int currentValue = graph.getNodeValue(currentNode);
            
            System.out.println("Langkah " + step + ":");
            System.out.println("  • Node dikunjungi: " + currentNode);
            System.out.println("  • Nilai node: " + currentValue);
            System.out.println("  • Queue saat ini: " + queue);
            System.out.println("  • Visited: " + visited);
            
            // Cek apakah nilai node sama dengan target
            if (currentValue == target) {
                System.out.println("\n✓ TARGET DITEMUKAN!");
                System.out.println("  Node: " + currentNode);
                System.out.println("  Nilai: " + currentValue);
                System.out.println("  Path pencarian: " + searchPath);
                return currentNode;
            }
            
            // Tambahkan tetangga ke queue
            List<String> neighbors = graph.getNeighbors(currentNode);
            System.out.println("  • Tetangga: " + neighbors);
            
            for (String neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.offer(neighbor);
                    visited.add(neighbor);
                }
            }
            
            System.out.println("  • Queue setelah enqueue: " + queue);
            System.out.println();
            step++;
        }
        
        System.out.println("✗ Target tidak ditemukan dalam graf");
        System.out.println("Path pencarian: " + searchPath);
        return null;
    }
    
    // ==================== MAIN PROGRAM ====================
    
    public static void main(String[] args) {
        // Membuat graf dengan 8 node
        Graph graph = new Graph();
        
        // Menambahkan node dengan nilai
        graph.addNode("a1", 10);
        graph.addNode("a2", 25);
        graph.addNode("a3", 15);
        graph.addNode("a4", 30);
        graph.addNode("a5", 40);
        graph.addNode("a6", 20);
        graph.addNode("a7", 35);
        graph.addNode("a8", 50);
        
        // Menambahkan edge (hubungan antar node)
        // Struktur graf berbentuk tree dengan beberapa cross edges
        graph.addEdge("a1", "a2");
        graph.addEdge("a1", "a3");
        graph.addEdge("a2", "a4");
        graph.addEdge("a2", "a5");
        graph.addEdge("a3", "a6");
        graph.addEdge("a3", "a7");
        graph.addEdge("a5", "a8");
        graph.addEdge("a7", "a8");
        
        // Menampilkan struktur graf
        graph.displayGraph();
        
        System.out.println("\n" + "=".repeat(50));
        
        // Melakukan pencarian dengan DFS
        int targetDFS = 35;
        dfsSearch(graph, "a1", targetDFS);
        
        System.out.println("\n" + "=".repeat(50));
        
        // Melakukan pencarian dengan BFS
        int targetBFS = 35;
        bfsSearch(graph, "a1", targetBFS);
        
        System.out.println("\n" + "=".repeat(50));
    }
}