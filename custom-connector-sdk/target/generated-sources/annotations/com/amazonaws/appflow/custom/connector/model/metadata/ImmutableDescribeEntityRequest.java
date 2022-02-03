package com.amazonaws.appflow.custom.connector.model.metadata;

import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link DescribeEntityRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDescribeEntityRequest.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
@JsonTypeName("DescribeEntityRequest")
public final class ImmutableDescribeEntityRequest
    implements DescribeEntityRequest {
  private final String entityIdentifier;
  private final ConnectorContext connectorContext;

  private ImmutableDescribeEntityRequest(
      String entityIdentifier,
      ConnectorContext connectorContext) {
    this.entityIdentifier = entityIdentifier;
    this.connectorContext = connectorContext;
  }

  /**
   * Unique identifier for the entity. Can be entityId/ entityName / entityPath+name / entityUrl etc.
   */
  @JsonProperty("entityIdentifier")
  @Override
  public String entityIdentifier() {
    return entityIdentifier;
  }

  /**
   * Context contains the connector settings, credentials and APi version etc.
   */
  @JsonProperty("connectorContext")
  @Override
  public ConnectorContext connectorContext() {
    return connectorContext;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeEntityRequest#entityIdentifier() entityIdentifier} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param entityIdentifier A new value for entityIdentifier
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeEntityRequest withEntityIdentifier(String entityIdentifier) {
    if (this.entityIdentifier.equals(entityIdentifier)) return this;
    String newValue = Objects.requireNonNull(entityIdentifier, "entityIdentifier");
    return new ImmutableDescribeEntityRequest(newValue, this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DescribeEntityRequest#connectorContext() connectorContext} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param connectorContext A new value for connectorContext
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableDescribeEntityRequest withConnectorContext(ConnectorContext connectorContext) {
    if (this.connectorContext == connectorContext) return this;
    ConnectorContext newValue = Objects.requireNonNull(connectorContext, "connectorContext");
    return new ImmutableDescribeEntityRequest(this.entityIdentifier, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDescribeEntityRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDescribeEntityRequest
        && equalTo((ImmutableDescribeEntityRequest) another);
  }

  private boolean equalTo(ImmutableDescribeEntityRequest another) {
    return entityIdentifier.equals(another.entityIdentifier)
        && connectorContext.equals(another.connectorContext);
  }

  /**
   * Computes a hash code from attributes: {@code entityIdentifier}, {@code connectorContext}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + entityIdentifier.hashCode();
    h = h * 17 + connectorContext.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code DescribeEntityRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "DescribeEntityRequest{"
        + "entityIdentifier=" + entityIdentifier
        + ", connectorContext=" + connectorContext
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonDeserialize
  @JsonTypeInfo(use=JsonTypeInfo.Id.NONE)
  @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE)
  static final class Json
      implements DescribeEntityRequest {
    @Nullable String entityIdentifier;
    @Nullable ConnectorContext connectorContext;
    @JsonProperty("entityIdentifier")
    public void setEntityIdentifier(String entityIdentifier) {
      this.entityIdentifier = entityIdentifier;
    }
    @JsonProperty("connectorContext")
    public void setConnectorContext(ConnectorContext connectorContext) {
      this.connectorContext = connectorContext;
    }
    @Override
    public String entityIdentifier() { throw new UnsupportedOperationException(); }
    @Override
    public ConnectorContext connectorContext() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator
  static ImmutableDescribeEntityRequest fromJson(Json json) {
    ImmutableDescribeEntityRequest.Builder builder = ImmutableDescribeEntityRequest.builder();
    if (json.entityIdentifier != null) {
      builder.entityIdentifier(json.entityIdentifier);
    }
    if (json.connectorContext != null) {
      builder.connectorContext(json.connectorContext);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link DescribeEntityRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable DescribeEntityRequest instance
   */
  public static ImmutableDescribeEntityRequest copyOf(DescribeEntityRequest instance) {
    if (instance instanceof ImmutableDescribeEntityRequest) {
      return (ImmutableDescribeEntityRequest) instance;
    }
    return ImmutableDescribeEntityRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableDescribeEntityRequest ImmutableDescribeEntityRequest}.
   * @return A new ImmutableDescribeEntityRequest builder
   */
  public static ImmutableDescribeEntityRequest.Builder builder() {
    return new ImmutableDescribeEntityRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDescribeEntityRequest ImmutableDescribeEntityRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ENTITY_IDENTIFIER = 0x1L;
    private static final long INIT_BIT_CONNECTOR_CONTEXT = 0x2L;
    private long initBits = 0x3L;

    private @Nullable String entityIdentifier;
    private @Nullable ConnectorContext connectorContext;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code DescribeEntityRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(DescribeEntityRequest instance) {
      Objects.requireNonNull(instance, "instance");
      entityIdentifier(instance.entityIdentifier());
      connectorContext(instance.connectorContext());
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeEntityRequest#entityIdentifier() entityIdentifier} attribute.
     * @param entityIdentifier The value for entityIdentifier 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityIdentifier(String entityIdentifier) {
      this.entityIdentifier = Objects.requireNonNull(entityIdentifier, "entityIdentifier");
      initBits &= ~INIT_BIT_ENTITY_IDENTIFIER;
      return this;
    }

    /**
     * Initializes the value for the {@link DescribeEntityRequest#connectorContext() connectorContext} attribute.
     * @param connectorContext The value for connectorContext 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorContext(ConnectorContext connectorContext) {
      this.connectorContext = Objects.requireNonNull(connectorContext, "connectorContext");
      initBits &= ~INIT_BIT_CONNECTOR_CONTEXT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableDescribeEntityRequest ImmutableDescribeEntityRequest}.
     * @return An immutable instance of DescribeEntityRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDescribeEntityRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableDescribeEntityRequest(entityIdentifier, connectorContext);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_ENTITY_IDENTIFIER) != 0) attributes.add("entityIdentifier");
      if ((initBits & INIT_BIT_CONNECTOR_CONTEXT) != 0) attributes.add("connectorContext");
      return "Cannot build DescribeEntityRequest, some of required attributes are not set " + attributes;
    }
  }
}
