package deadlock_detector;

import graph.GPEdge;
import graph.GPNode;

/*its a node subclass that restricts the destination edges's nodes, destination nodes can never be the same type that it
 * */
public class MyProcessNode<NodeElement extends MyProcess> extends GPNode<NodeElement>{

	public MyProcessNode(NodeElement value) {
		super(value);
	}
	
	@Override
	public Boolean addEdge(GPEdge<?> edge) {
		GPNode<?> destinationNode = edge.getDestinationVertex();
		if(destinationNode instanceof MyProcessNode<?>) {
			return false;
		}
				
		return super.addEdge(edge);
	}
}
