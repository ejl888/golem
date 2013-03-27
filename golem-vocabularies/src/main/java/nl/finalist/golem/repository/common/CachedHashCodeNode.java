package nl.finalist.golem.repository.common;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Cache hascode implementation for Node's. @see 
 * http://static.springsource.org/spring-data/data-neo4j/docs/current/reference/html/programming-model.html#d0e1725
 * 
 * @author ernst-jan
 *
 */
@NodeEntity
public class CachedHashCodeNode {
    @GraphId private Long nodeId;

    transient private Integer hash;

    final public Long getNodeId() {
        return nodeId;
    }
    
    final public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (nodeId == null) {
            return false;
        }

        if (!(getClass().isInstance(other))) {
            return false;
        }

        return nodeId.equals(((CachedHashCodeNode) other).nodeId);
    }

    final public int hashCode() {
        if (hash == null) {
            hash = nodeId == null ? System.identityHashCode(this) : nodeId.hashCode();
        }
        return hash.hashCode();
    }
}
