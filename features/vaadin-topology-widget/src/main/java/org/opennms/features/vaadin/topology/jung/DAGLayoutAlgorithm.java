package org.opennms.features.vaadin.topology.jung;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.List;

import org.apache.commons.collections15.Transformer;
import org.opennms.features.vaadin.topology.Edge;
import org.opennms.features.vaadin.topology.Graph;
import org.opennms.features.vaadin.topology.GraphContainer;
import org.opennms.features.vaadin.topology.LayoutAlgorithm;
import org.opennms.features.vaadin.topology.Vertex;

import edu.uci.ics.jung.algorithms.layout.DAGLayout;
import edu.uci.ics.jung.graph.SparseGraph;

public class DAGLayoutAlgorithm implements LayoutAlgorithm {
	
	public Object m_rootItemId;
	
	public DAGLayoutAlgorithm(Object rootItemId) {
		m_rootItemId = rootItemId;
	}

	@Override
	public void updateLayout(GraphContainer graph) {
		
		Graph g = new Graph(graph);
		Vertex root = g.getVertexByItemId(m_rootItemId);
		
		int szl = g.getSemanticZoomLevel();
		
		
		SparseGraph<Vertex, Edge> jungGraph = new SparseGraph<Vertex, Edge>();
		
		
		List<Vertex> vertices = g.getVertices(szl);
		
		for(Vertex v : vertices) {
			jungGraph.addVertex(v);
		}
		
		List<Edge> edges = g.getEdges(szl);
		
		for(Edge e : edges) {
			jungGraph.addEdge(e, e.getSource(), e.getTarget());
		}
		

		DAGLayout<Vertex,Edge> layout = new DAGLayout<Vertex, Edge>(jungGraph);
		layout.setRoot(root);
		layout.setInitializer(new Transformer<Vertex, Point2D>() {
			@Override
			public Point2D transform(Vertex v) {
				return new Point(v.getX(), v.getY());
			}
		});
		layout.setSize(new Dimension(750,750));
		
		for(Vertex v : vertices) {
			layout.lock(v, v.isLocked());
		}
		

		
		while(!layout.done()) {
			layout.step();
		}
		
		
		for(Vertex v : vertices) {
			v.setX((int)layout.getX(v));
			v.setY((int)layout.getY(v));
		}
		
		
		
		
	}

}
