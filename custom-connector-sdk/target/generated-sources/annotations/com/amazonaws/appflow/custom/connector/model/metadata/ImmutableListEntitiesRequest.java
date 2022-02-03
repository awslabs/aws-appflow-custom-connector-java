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
 * Immutable implementation of {@link ListEntitiesRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableListEntitiesRequest.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
@JsonTypeName("ListEntitiesRequest")
public final class ImmutableListEntitiesRequest
    implements ListEntitiesRequest {
  private final @Nullable String entitiesPath;
  private final @Nullable Long maxResult;
  private final @Nullable String nextToken;
  private final ConnectorContext connectorContext;

  private ImmutableListEntitiesRequest(ImmutableListEntitiesRequest.Builder builder) {
    this.entitiesPath = builder.entitiesPath;
    this.nextToken = builder.nextToken;
    this.connectorContext = builder.connectorContext;
    this.maxResult = builder.maxResultIsSet()
        ? builder.maxResult
        : ListEntitiesRequest.super.maxResult();
  }

  private ImmutableListEntitiesRequest(
      @Nullable String entitiesPath,
      @Nullable Long maxResult,
      @Nullable String nextToken,
      ConnectorContext connectorContext) {
    this.entitiesPath = entitiesPath;
    this.maxResult = maxResult;
    this.nextToken = nextToken;
    this.connectorContext = connectorContext;
  }

  /**
   * Path/URI of entities.
   */
  @JsonProperty("entitiesPath")
  @Override
  public @Nullable String entitiesPath() {
    return entitiesPath;
  }

  /**
   * Maximum number of records needs to be returned as part of single call. Default value is 1000.
   */
  @JsonProperty("maxResult")
  @Override
  public @Nullable Long maxResult() {
    return maxResult;
  }

  /**
   * The pagination token - next page should start from this token value.
   */
  @JsonProperty("nextToken")
  @Override
  public @Nullable String nextToken() {
    return nextToken;
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
   * Copy the current immutable object by setting a value for the {@link ListEntitiesRequest#entitiesPath() entitiesPath} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param entitiesPath A new value for entitiesPath (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableListEntitiesRequest withEntitiesPath(@Nullable String entitiesPath) {
    if (Objects.equals(this.entitiesPath, entitiesPath)) return this;
    return new ImmutableListEntitiesRequest(entitiesPath, this.maxResult, this.nextToken, this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ListEntitiesRequest#maxResult() maxResult} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param maxResult A new value for maxResult (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableListEntitiesRequest withMaxResult(@Nullable Long maxResult) {
    if (Objects.equals(this.maxResult, maxResult)) return this;
    return new ImmutableListEntitiesRequest(this.entitiesPath, maxResult, this.nextToken, this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ListEntitiesRequest#nextToken() nextToken} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param nextToken A new value for nextToken (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableListEntitiesRequest withNextToken(@Nullable String nextToken) {
    if (Objects.equals(this.nextToken, nextToken)) return this;
    return new ImmutableListEntitiesRequest(this.entitiesPath, this.maxResult, nextToken, this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link ListEntitiesRequest#connectorContext() connectorContext} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param connectorContext A new value for connectorContext
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableListEntitiesRequest withConnectorContext(ConnectorContext connectorContext) {
    if (this.connectorContext == connectorContext) return this;
    ConnectorContext newValue = Objects.requireNonNull(connectorContext, "connectorContext");
    return new ImmutableListEntitiesRequest(this.entitiesPath, this.maxResult, this.nextToken, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableListEntitiesRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableListEntitiesRequest
        && equalTo((ImmutableListEntitiesRequest) another);
  }

  private boolean equalTo(ImmutableListEntitiesRequest another) {
    return Objects.equals(entitiesPath, another.entitiesPath)
        && Objects.equals(maxResult, another.maxResult)
        && Objects.equals(nextToken, another.nextToken)
        && connectorContext.equals(another.connectorContext);
  }

  /**
   * Computes a hash code from attributes: {@code entitiesPath}, {@code maxResult}, {@code nextToken}, {@code connectorContext}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + Objects.hashCode(entitiesPath);
    h = h * 17 + Objects.hashCode(maxResult);
    h = h * 17 + Objects.hashCode(nextToken);
    h = h * 17 + connectorContext.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code ListEntitiesRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "ListEntitiesRequest{"
        + "entitiesPath=" + entitiesPath
        + ", maxResult=" + maxResult
        + ", nextToken=" + nextToken
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
  static final class Json implements ListEntitiesRequest {
    @Nullable String entitiesPath;
    @Nullable Long maxResult;
    boolean maxResultIsSet;
    @Nullable String nextToken;
    @Nullable ConnectorContext connectorContext;
    @JsonProperty("entitiesPath")
    public void setEntitiesPath(@Nullable String entitiesPath) {
      this.entitiesPath = entitiesPath;
    }
    @JsonProperty("maxResult")
    public void setMaxResult(@Nullable Long maxResult) {
      this.maxResult = maxResult;
      this.maxResultIsSet = true;
    }
    @JsonProperty("nextToken")
    public void setNextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
    }
    @JsonProperty("connectorContext")
    public void setConnectorContext(ConnectorContext connectorContext) {
      this.connectorContext = connectorContext;
    }
    @Override
    public String entitiesPath() { throw new UnsupportedOperationException(); }
    @Override
    public Long maxResult() { throw new UnsupportedOperationException(); }
    @Override
    public String nextToken() { throw new UnsupportedOperationException(); }
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
  static ImmutableListEntitiesRequest fromJson(Json json) {
    ImmutableListEntitiesRequest.Builder builder = ImmutableListEntitiesRequest.builder();
    if (json.entitiesPath != null) {
      builder.entitiesPath(json.entitiesPath);
    }
    if (json.maxResultIsSet) {
      builder.maxResult(json.maxResult);
    }
    if (json.nextToken != null) {
      builder.nextToken(json.nextToken);
    }
    if (json.connectorContext != null) {
      builder.connectorContext(json.connectorContext);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link ListEntitiesRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable ListEntitiesRequest instance
   */
  public static ImmutableListEntitiesRequest copyOf(ListEntitiesRequest instance) {
    if (instance instanceof ImmutableListEntitiesRequest) {
      return (ImmutableListEntitiesRequest) instance;
    }
    return ImmutableListEntitiesRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableListEntitiesRequest ImmutableListEntitiesRequest}.
   * @return A new ImmutableListEntitiesRequest builder
   */
  public static ImmutableListEntitiesRequest.Builder builder() {
    return new ImmutableListEntitiesRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableListEntitiesRequest ImmutableListEntitiesRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_CONNECTOR_CONTEXT = 0x1L;
    private static final long OPT_BIT_MAX_RESULT = 0x1L;
    private long initBits = 0x1L;
    private long optBits;

    private @Nullable String entitiesPath;
    private @Nullable Long maxResult;
    private @Nullable String nextToken;
    private @Nullable ConnectorContext connectorContext;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code ListEntitiesRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(ListEntitiesRequest instance) {
      Objects.requireNonNull(instance, "instance");
      @Nullable String entitiesPathValue = instance.entitiesPath();
      if (entitiesPathValue != null) {
        entitiesPath(entitiesPathValue);
      }
      @Nullable Long maxResultValue = instance.maxResult();
      if (maxResultValue != null) {
        maxResult(maxResultValue);
      }
      @Nullable String nextTokenValue = instance.nextToken();
      if (nextTokenValue != null) {
        nextToken(nextTokenValue);
      }
      connectorContext(instance.connectorContext());
      return this;
    }

    /**
     * Initializes the value for the {@link ListEntitiesRequest#entitiesPath() entitiesPath} attribute.
     * @param entitiesPath The value for entitiesPath (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entitiesPath(@Nullable String entitiesPath) {
      this.entitiesPath = entitiesPath;
      return this;
    }

    /**
     * Initializes the value for the {@link ListEntitiesRequest#maxResult() maxResult} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link ListEntitiesRequest#maxResult() maxResult}.</em>
     * @param maxResult The value for maxResult (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder maxResult(@Nullable Long maxResult) {
      this.maxResult = maxResult;
      optBits |= OPT_BIT_MAX_RESULT;
      return this;
    }

    /**
     * Initializes the value for the {@link ListEntitiesRequest#nextToken() nextToken} attribute.
     * @param nextToken The value for nextToken (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder nextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
      return this;
    }

    /**
     * Initializes the value for the {@link ListEntitiesRequest#connectorContext() connectorContext} attribute.
     * @param connectorContext The value for connectorContext 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorContext(ConnectorContext connectorContext) {
      this.connectorContext = Objects.requireNonNull(connectorContext, "connectorContext");
      initBits &= ~INIT_BIT_CONNECTOR_CONTEXT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableListEntitiesRequest ImmutableListEntitiesRequest}.
     * @return An immutable instance of ListEntitiesRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableListEntitiesRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableListEntitiesRequest(this);
    }

    private boolean maxResultIsSet() {
      return (optBits & OPT_BIT_MAX_RESULT) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_CONNECTOR_CONTEXT) != 0) attributes.add("connectorContext");
      return "Cannot build ListEntitiesRequest, some of required attributes are not set " + attributes;
    }
  }
}
