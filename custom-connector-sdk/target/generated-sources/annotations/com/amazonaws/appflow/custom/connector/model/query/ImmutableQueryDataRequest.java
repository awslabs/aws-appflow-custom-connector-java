package com.amazonaws.appflow.custom.connector.model.query;

import com.amazonaws.appflow.custom.connector.model.ConnectorContext;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link QueryDataRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableQueryDataRequest.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
@JsonTypeName("QueryDataRequest")
public final class ImmutableQueryDataRequest
    implements QueryDataRequest {
  private final String entityIdentifier;
  private final @Nullable List<String> selectedFieldNames;
  private final @Nullable String filterExpression;
  private final Long maxResults;
  private final @Nullable String nextToken;
  private final ConnectorContext connectorContext;

  private ImmutableQueryDataRequest(ImmutableQueryDataRequest.Builder builder) {
    this.entityIdentifier = builder.entityIdentifier;
    this.selectedFieldNames = builder.selectedFieldNames == null ? null : createUnmodifiableList(true, builder.selectedFieldNames);
    this.filterExpression = builder.filterExpression;
    this.nextToken = builder.nextToken;
    this.connectorContext = builder.connectorContext;
    this.maxResults = builder.maxResults != null
        ? builder.maxResults
        : Objects.requireNonNull(QueryDataRequest.super.maxResults(), "maxResults");
  }

  private ImmutableQueryDataRequest(
      String entityIdentifier,
      @Nullable List<String> selectedFieldNames,
      @Nullable String filterExpression,
      Long maxResults,
      @Nullable String nextToken,
      ConnectorContext connectorContext) {
    this.entityIdentifier = entityIdentifier;
    this.selectedFieldNames = selectedFieldNames;
    this.filterExpression = filterExpression;
    this.maxResults = maxResults;
    this.nextToken = nextToken;
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
   * Field values to retrieve. If null, it will provide all the fields for the entity.
   */
  @JsonProperty("selectedFieldNames")
  @Override
  public @Nullable List<String> selectedFieldNames() {
    return selectedFieldNames;
  }

  /**
   * Filter expression string similar to the WHERE clause in SQL.
   */
  @JsonProperty("filterExpression")
  @Override
  public @Nullable String filterExpression() {
    return filterExpression;
  }

  /**
   * Maximum number of records needs to be returned as part of single call. Default value is 1000.
   */
  @JsonProperty("maxResults")
  @Override
  public Long maxResults() {
    return maxResults;
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
   * Copy the current immutable object by setting a value for the {@link QueryDataRequest#entityIdentifier() entityIdentifier} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param entityIdentifier A new value for entityIdentifier
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryDataRequest withEntityIdentifier(String entityIdentifier) {
    if (this.entityIdentifier.equals(entityIdentifier)) return this;
    String newValue = Objects.requireNonNull(entityIdentifier, "entityIdentifier");
    return new ImmutableQueryDataRequest(
        newValue,
        this.selectedFieldNames,
        this.filterExpression,
        this.maxResults,
        this.nextToken,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link QueryDataRequest#selectedFieldNames() selectedFieldNames}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableQueryDataRequest withSelectedFieldNames(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableQueryDataRequest(
          this.entityIdentifier,
          null,
          this.filterExpression,
          this.maxResults,
          this.nextToken,
          this.connectorContext);
    }
    @Nullable List<String> newValue = Arrays.asList(elements) == null ? null : createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableQueryDataRequest(
        this.entityIdentifier,
        newValue,
        this.filterExpression,
        this.maxResults,
        this.nextToken,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link QueryDataRequest#selectedFieldNames() selectedFieldNames}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of selectedFieldNames elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableQueryDataRequest withSelectedFieldNames(@Nullable Iterable<String> elements) {
    if (this.selectedFieldNames == elements) return this;
    @Nullable List<String> newValue = elements == null ? null : createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableQueryDataRequest(
        this.entityIdentifier,
        newValue,
        this.filterExpression,
        this.maxResults,
        this.nextToken,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryDataRequest#filterExpression() filterExpression} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param filterExpression A new value for filterExpression (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryDataRequest withFilterExpression(@Nullable String filterExpression) {
    if (Objects.equals(this.filterExpression, filterExpression)) return this;
    return new ImmutableQueryDataRequest(
        this.entityIdentifier,
        this.selectedFieldNames,
        filterExpression,
        this.maxResults,
        this.nextToken,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryDataRequest#maxResults() maxResults} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param maxResults A new value for maxResults
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryDataRequest withMaxResults(Long maxResults) {
    if (this.maxResults.equals(maxResults)) return this;
    Long newValue = Objects.requireNonNull(maxResults, "maxResults");
    return new ImmutableQueryDataRequest(
        this.entityIdentifier,
        this.selectedFieldNames,
        this.filterExpression,
        newValue,
        this.nextToken,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryDataRequest#nextToken() nextToken} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param nextToken A new value for nextToken (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryDataRequest withNextToken(@Nullable String nextToken) {
    if (Objects.equals(this.nextToken, nextToken)) return this;
    return new ImmutableQueryDataRequest(
        this.entityIdentifier,
        this.selectedFieldNames,
        this.filterExpression,
        this.maxResults,
        nextToken,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryDataRequest#connectorContext() connectorContext} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param connectorContext A new value for connectorContext
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryDataRequest withConnectorContext(ConnectorContext connectorContext) {
    if (this.connectorContext == connectorContext) return this;
    ConnectorContext newValue = Objects.requireNonNull(connectorContext, "connectorContext");
    return new ImmutableQueryDataRequest(
        this.entityIdentifier,
        this.selectedFieldNames,
        this.filterExpression,
        this.maxResults,
        this.nextToken,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableQueryDataRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableQueryDataRequest
        && equalTo((ImmutableQueryDataRequest) another);
  }

  private boolean equalTo(ImmutableQueryDataRequest another) {
    return entityIdentifier.equals(another.entityIdentifier)
        && Objects.equals(selectedFieldNames, another.selectedFieldNames)
        && Objects.equals(filterExpression, another.filterExpression)
        && maxResults.equals(another.maxResults)
        && Objects.equals(nextToken, another.nextToken)
        && connectorContext.equals(another.connectorContext);
  }

  /**
   * Computes a hash code from attributes: {@code entityIdentifier}, {@code selectedFieldNames}, {@code filterExpression}, {@code maxResults}, {@code nextToken}, {@code connectorContext}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + entityIdentifier.hashCode();
    h = h * 17 + Objects.hashCode(selectedFieldNames);
    h = h * 17 + Objects.hashCode(filterExpression);
    h = h * 17 + maxResults.hashCode();
    h = h * 17 + Objects.hashCode(nextToken);
    h = h * 17 + connectorContext.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code QueryDataRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "QueryDataRequest{"
        + "entityIdentifier=" + entityIdentifier
        + ", selectedFieldNames=" + selectedFieldNames
        + ", filterExpression=" + filterExpression
        + ", maxResults=" + maxResults
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
  static final class Json implements QueryDataRequest {
    @Nullable String entityIdentifier;
    List<String> selectedFieldNames = null;
    @Nullable String filterExpression;
    @Nullable Long maxResults;
    @Nullable String nextToken;
    @Nullable ConnectorContext connectorContext;
    @JsonProperty("entityIdentifier")
    public void setEntityIdentifier(String entityIdentifier) {
      this.entityIdentifier = entityIdentifier;
    }
    @JsonProperty("selectedFieldNames")
    public void setSelectedFieldNames(@Nullable List<String> selectedFieldNames) {
      this.selectedFieldNames = selectedFieldNames;
    }
    @JsonProperty("filterExpression")
    public void setFilterExpression(@Nullable String filterExpression) {
      this.filterExpression = filterExpression;
    }
    @JsonProperty("maxResults")
    public void setMaxResults(Long maxResults) {
      this.maxResults = maxResults;
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
    public String entityIdentifier() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> selectedFieldNames() { throw new UnsupportedOperationException(); }
    @Override
    public String filterExpression() { throw new UnsupportedOperationException(); }
    @Override
    public Long maxResults() { throw new UnsupportedOperationException(); }
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
  static ImmutableQueryDataRequest fromJson(Json json) {
    ImmutableQueryDataRequest.Builder builder = ImmutableQueryDataRequest.builder();
    if (json.entityIdentifier != null) {
      builder.entityIdentifier(json.entityIdentifier);
    }
    if (json.selectedFieldNames != null) {
      builder.addAllSelectedFieldNames(json.selectedFieldNames);
    }
    if (json.filterExpression != null) {
      builder.filterExpression(json.filterExpression);
    }
    if (json.maxResults != null) {
      builder.maxResults(json.maxResults);
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
   * Creates an immutable copy of a {@link QueryDataRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable QueryDataRequest instance
   */
  public static ImmutableQueryDataRequest copyOf(QueryDataRequest instance) {
    if (instance instanceof ImmutableQueryDataRequest) {
      return (ImmutableQueryDataRequest) instance;
    }
    return ImmutableQueryDataRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableQueryDataRequest ImmutableQueryDataRequest}.
   * @return A new ImmutableQueryDataRequest builder
   */
  public static ImmutableQueryDataRequest.Builder builder() {
    return new ImmutableQueryDataRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableQueryDataRequest ImmutableQueryDataRequest}.
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
    private List<String> selectedFieldNames = null;
    private @Nullable String filterExpression;
    private @Nullable Long maxResults;
    private @Nullable String nextToken;
    private @Nullable ConnectorContext connectorContext;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code QueryDataRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(QueryDataRequest instance) {
      Objects.requireNonNull(instance, "instance");
      entityIdentifier(instance.entityIdentifier());
      @Nullable List<String> selectedFieldNamesValue = instance.selectedFieldNames();
      if (selectedFieldNamesValue != null) {
        addAllSelectedFieldNames(selectedFieldNamesValue);
      }
      @Nullable String filterExpressionValue = instance.filterExpression();
      if (filterExpressionValue != null) {
        filterExpression(filterExpressionValue);
      }
      maxResults(instance.maxResults());
      @Nullable String nextTokenValue = instance.nextToken();
      if (nextTokenValue != null) {
        nextToken(nextTokenValue);
      }
      connectorContext(instance.connectorContext());
      return this;
    }

    /**
     * Initializes the value for the {@link QueryDataRequest#entityIdentifier() entityIdentifier} attribute.
     * @param entityIdentifier The value for entityIdentifier 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityIdentifier(String entityIdentifier) {
      this.entityIdentifier = Objects.requireNonNull(entityIdentifier, "entityIdentifier");
      initBits &= ~INIT_BIT_ENTITY_IDENTIFIER;
      return this;
    }

    /**
     * Adds one element to {@link QueryDataRequest#selectedFieldNames() selectedFieldNames} list.
     * @param element A selectedFieldNames element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSelectedFieldNames(String element) {
      if (this.selectedFieldNames == null) {
        this.selectedFieldNames = new ArrayList<String>();
      }
      this.selectedFieldNames.add(Objects.requireNonNull(element, "selectedFieldNames element"));
      return this;
    }

    /**
     * Adds elements to {@link QueryDataRequest#selectedFieldNames() selectedFieldNames} list.
     * @param elements An array of selectedFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSelectedFieldNames(String... elements) {
      if (this.selectedFieldNames == null) {
        this.selectedFieldNames = new ArrayList<String>();
      }
      for (String element : elements) {
        this.selectedFieldNames.add(Objects.requireNonNull(element, "selectedFieldNames element"));
      }
      return this;
    }

    /**
     * Sets or replaces all elements for {@link QueryDataRequest#selectedFieldNames() selectedFieldNames} list.
     * @param elements An iterable of selectedFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder selectedFieldNames(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.selectedFieldNames = null;
        return this;
      }
      this.selectedFieldNames = new ArrayList<String>();
      return addAllSelectedFieldNames(elements);
    }

    /**
     * Adds elements to {@link QueryDataRequest#selectedFieldNames() selectedFieldNames} list.
     * @param elements An iterable of selectedFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSelectedFieldNames(Iterable<String> elements) {
      Objects.requireNonNull(elements, "selectedFieldNames element");
      if (this.selectedFieldNames == null) {
        this.selectedFieldNames = new ArrayList<String>();
      }
      for (String element : elements) {
        this.selectedFieldNames.add(Objects.requireNonNull(element, "selectedFieldNames element"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link QueryDataRequest#filterExpression() filterExpression} attribute.
     * @param filterExpression The value for filterExpression (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder filterExpression(@Nullable String filterExpression) {
      this.filterExpression = filterExpression;
      return this;
    }

    /**
     * Initializes the value for the {@link QueryDataRequest#maxResults() maxResults} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link QueryDataRequest#maxResults() maxResults}.</em>
     * @param maxResults The value for maxResults 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder maxResults(Long maxResults) {
      this.maxResults = Objects.requireNonNull(maxResults, "maxResults");
      return this;
    }

    /**
     * Initializes the value for the {@link QueryDataRequest#nextToken() nextToken} attribute.
     * @param nextToken The value for nextToken (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder nextToken(@Nullable String nextToken) {
      this.nextToken = nextToken;
      return this;
    }

    /**
     * Initializes the value for the {@link QueryDataRequest#connectorContext() connectorContext} attribute.
     * @param connectorContext The value for connectorContext 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorContext(ConnectorContext connectorContext) {
      this.connectorContext = Objects.requireNonNull(connectorContext, "connectorContext");
      initBits &= ~INIT_BIT_CONNECTOR_CONTEXT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableQueryDataRequest ImmutableQueryDataRequest}.
     * @return An immutable instance of QueryDataRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableQueryDataRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableQueryDataRequest(this);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_ENTITY_IDENTIFIER) != 0) attributes.add("entityIdentifier");
      if ((initBits & INIT_BIT_CONNECTOR_CONTEXT) != 0) attributes.add("connectorContext");
      return "Cannot build QueryDataRequest, some of required attributes are not set " + attributes;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<T>();
    } else {
      list = new ArrayList<T>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<T>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
