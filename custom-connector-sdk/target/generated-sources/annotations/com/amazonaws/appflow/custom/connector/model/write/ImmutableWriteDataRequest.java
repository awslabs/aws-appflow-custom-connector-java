package com.amazonaws.appflow.custom.connector.model.write;

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
 * Immutable implementation of {@link WriteDataRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableWriteDataRequest.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
@JsonTypeName("WriteDataRequest")
public final class ImmutableWriteDataRequest
    implements WriteDataRequest {
  private final String entityIdentifier;
  private final WriteOperationType operation;
  private final @Nullable List<String> idFieldNames;
  private final @Nullable List<String> records;
  private final @Nullable Boolean allOrNone;
  private final ConnectorContext connectorContext;

  private ImmutableWriteDataRequest(
      String entityIdentifier,
      WriteOperationType operation,
      @Nullable List<String> idFieldNames,
      @Nullable List<String> records,
      @Nullable Boolean allOrNone,
      ConnectorContext connectorContext) {
    this.entityIdentifier = entityIdentifier;
    this.operation = operation;
    this.idFieldNames = idFieldNames;
    this.records = records;
    this.allOrNone = allOrNone;
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
   * Write operation type needs to be called.
   */
  @JsonProperty("operation")
  @Override
  public WriteOperationType operation() {
    return operation;
  }

  /**
   * Primary keys of the entity. Used for DELETE/ UPDATE/ UPSERT operations.
   */
  @JsonProperty("idFieldNames")
  @Override
  public @Nullable List<String> idFieldNames() {
    return idFieldNames;
  }

  /**
   * List of JSON serialized string of the entity record as per the entity metadata.
   */
  @JsonProperty("records")
  @Override
  public @Nullable List<String> records() {
    return records;
  }

  /**
   * Write all or none if any of the entity records error out.
   */
  @JsonProperty("allOrNone")
  @Override
  public @Nullable Boolean allOrNone() {
    return allOrNone;
  }

  /**
   * Context contains the connector settings, credentials and API version etc.
   */
  @JsonProperty("connectorContext")
  @Override
  public ConnectorContext connectorContext() {
    return connectorContext;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteDataRequest#entityIdentifier() entityIdentifier} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param entityIdentifier A new value for entityIdentifier
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteDataRequest withEntityIdentifier(String entityIdentifier) {
    if (this.entityIdentifier.equals(entityIdentifier)) return this;
    String newValue = Objects.requireNonNull(entityIdentifier, "entityIdentifier");
    return new ImmutableWriteDataRequest(
        newValue,
        this.operation,
        this.idFieldNames,
        this.records,
        this.allOrNone,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteDataRequest#operation() operation} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param operation A new value for operation
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteDataRequest withOperation(WriteOperationType operation) {
    if (this.operation == operation) return this;
    WriteOperationType newValue = Objects.requireNonNull(operation, "operation");
    return new ImmutableWriteDataRequest(
        this.entityIdentifier,
        newValue,
        this.idFieldNames,
        this.records,
        this.allOrNone,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link WriteDataRequest#idFieldNames() idFieldNames}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableWriteDataRequest withIdFieldNames(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableWriteDataRequest(
          this.entityIdentifier,
          this.operation,
          null,
          this.records,
          this.allOrNone,
          this.connectorContext);
    }
    @Nullable List<String> newValue = Arrays.asList(elements) == null ? null : createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableWriteDataRequest(
        this.entityIdentifier,
        this.operation,
        newValue,
        this.records,
        this.allOrNone,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link WriteDataRequest#idFieldNames() idFieldNames}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of idFieldNames elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableWriteDataRequest withIdFieldNames(@Nullable Iterable<String> elements) {
    if (this.idFieldNames == elements) return this;
    @Nullable List<String> newValue = elements == null ? null : createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableWriteDataRequest(
        this.entityIdentifier,
        this.operation,
        newValue,
        this.records,
        this.allOrNone,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link WriteDataRequest#records() records}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableWriteDataRequest withRecords(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableWriteDataRequest(
          this.entityIdentifier,
          this.operation,
          this.idFieldNames,
          null,
          this.allOrNone,
          this.connectorContext);
    }
    @Nullable List<String> newValue = Arrays.asList(elements) == null ? null : createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableWriteDataRequest(
        this.entityIdentifier,
        this.operation,
        this.idFieldNames,
        newValue,
        this.allOrNone,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link WriteDataRequest#records() records}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of records elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableWriteDataRequest withRecords(@Nullable Iterable<String> elements) {
    if (this.records == elements) return this;
    @Nullable List<String> newValue = elements == null ? null : createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableWriteDataRequest(
        this.entityIdentifier,
        this.operation,
        this.idFieldNames,
        newValue,
        this.allOrNone,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteDataRequest#allOrNone() allOrNone} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param allOrNone A new value for allOrNone (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteDataRequest withAllOrNone(@Nullable Boolean allOrNone) {
    if (Objects.equals(this.allOrNone, allOrNone)) return this;
    return new ImmutableWriteDataRequest(
        this.entityIdentifier,
        this.operation,
        this.idFieldNames,
        this.records,
        allOrNone,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link WriteDataRequest#connectorContext() connectorContext} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param connectorContext A new value for connectorContext
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableWriteDataRequest withConnectorContext(ConnectorContext connectorContext) {
    if (this.connectorContext == connectorContext) return this;
    ConnectorContext newValue = Objects.requireNonNull(connectorContext, "connectorContext");
    return new ImmutableWriteDataRequest(
        this.entityIdentifier,
        this.operation,
        this.idFieldNames,
        this.records,
        this.allOrNone,
        newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableWriteDataRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableWriteDataRequest
        && equalTo((ImmutableWriteDataRequest) another);
  }

  private boolean equalTo(ImmutableWriteDataRequest another) {
    return entityIdentifier.equals(another.entityIdentifier)
        && operation.equals(another.operation)
        && Objects.equals(idFieldNames, another.idFieldNames)
        && Objects.equals(records, another.records)
        && Objects.equals(allOrNone, another.allOrNone)
        && connectorContext.equals(another.connectorContext);
  }

  /**
   * Computes a hash code from attributes: {@code entityIdentifier}, {@code operation}, {@code idFieldNames}, {@code records}, {@code allOrNone}, {@code connectorContext}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + entityIdentifier.hashCode();
    h = h * 17 + operation.hashCode();
    h = h * 17 + Objects.hashCode(idFieldNames);
    h = h * 17 + Objects.hashCode(records);
    h = h * 17 + Objects.hashCode(allOrNone);
    h = h * 17 + connectorContext.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code WriteDataRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "WriteDataRequest{"
        + "entityIdentifier=" + entityIdentifier
        + ", operation=" + operation
        + ", idFieldNames=" + idFieldNames
        + ", records=" + records
        + ", allOrNone=" + allOrNone
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
  static final class Json implements WriteDataRequest {
    @Nullable String entityIdentifier;
    @Nullable WriteOperationType operation;
    List<String> idFieldNames = null;
    List<String> records = null;
    @Nullable Boolean allOrNone;
    @Nullable ConnectorContext connectorContext;
    @JsonProperty("entityIdentifier")
    public void setEntityIdentifier(String entityIdentifier) {
      this.entityIdentifier = entityIdentifier;
    }
    @JsonProperty("operation")
    public void setOperation(WriteOperationType operation) {
      this.operation = operation;
    }
    @JsonProperty("idFieldNames")
    public void setIdFieldNames(@Nullable List<String> idFieldNames) {
      this.idFieldNames = idFieldNames;
    }
    @JsonProperty("records")
    public void setRecords(@Nullable List<String> records) {
      this.records = records;
    }
    @JsonProperty("allOrNone")
    public void setAllOrNone(@Nullable Boolean allOrNone) {
      this.allOrNone = allOrNone;
    }
    @JsonProperty("connectorContext")
    public void setConnectorContext(ConnectorContext connectorContext) {
      this.connectorContext = connectorContext;
    }
    @Override
    public String entityIdentifier() { throw new UnsupportedOperationException(); }
    @Override
    public WriteOperationType operation() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> idFieldNames() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> records() { throw new UnsupportedOperationException(); }
    @Override
    public Boolean allOrNone() { throw new UnsupportedOperationException(); }
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
  static ImmutableWriteDataRequest fromJson(Json json) {
    ImmutableWriteDataRequest.Builder builder = ImmutableWriteDataRequest.builder();
    if (json.entityIdentifier != null) {
      builder.entityIdentifier(json.entityIdentifier);
    }
    if (json.operation != null) {
      builder.operation(json.operation);
    }
    if (json.idFieldNames != null) {
      builder.addAllIdFieldNames(json.idFieldNames);
    }
    if (json.records != null) {
      builder.addAllRecords(json.records);
    }
    if (json.allOrNone != null) {
      builder.allOrNone(json.allOrNone);
    }
    if (json.connectorContext != null) {
      builder.connectorContext(json.connectorContext);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link WriteDataRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable WriteDataRequest instance
   */
  public static ImmutableWriteDataRequest copyOf(WriteDataRequest instance) {
    if (instance instanceof ImmutableWriteDataRequest) {
      return (ImmutableWriteDataRequest) instance;
    }
    return ImmutableWriteDataRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableWriteDataRequest ImmutableWriteDataRequest}.
   * @return A new ImmutableWriteDataRequest builder
   */
  public static ImmutableWriteDataRequest.Builder builder() {
    return new ImmutableWriteDataRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableWriteDataRequest ImmutableWriteDataRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_ENTITY_IDENTIFIER = 0x1L;
    private static final long INIT_BIT_OPERATION = 0x2L;
    private static final long INIT_BIT_CONNECTOR_CONTEXT = 0x4L;
    private long initBits = 0x7L;

    private @Nullable String entityIdentifier;
    private @Nullable WriteOperationType operation;
    private List<String> idFieldNames = null;
    private List<String> records = null;
    private @Nullable Boolean allOrNone;
    private @Nullable ConnectorContext connectorContext;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code WriteDataRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(WriteDataRequest instance) {
      Objects.requireNonNull(instance, "instance");
      entityIdentifier(instance.entityIdentifier());
      operation(instance.operation());
      @Nullable List<String> idFieldNamesValue = instance.idFieldNames();
      if (idFieldNamesValue != null) {
        addAllIdFieldNames(idFieldNamesValue);
      }
      @Nullable List<String> recordsValue = instance.records();
      if (recordsValue != null) {
        addAllRecords(recordsValue);
      }
      @Nullable Boolean allOrNoneValue = instance.allOrNone();
      if (allOrNoneValue != null) {
        allOrNone(allOrNoneValue);
      }
      connectorContext(instance.connectorContext());
      return this;
    }

    /**
     * Initializes the value for the {@link WriteDataRequest#entityIdentifier() entityIdentifier} attribute.
     * @param entityIdentifier The value for entityIdentifier 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityIdentifier(String entityIdentifier) {
      this.entityIdentifier = Objects.requireNonNull(entityIdentifier, "entityIdentifier");
      initBits &= ~INIT_BIT_ENTITY_IDENTIFIER;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteDataRequest#operation() operation} attribute.
     * @param operation The value for operation 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder operation(WriteOperationType operation) {
      this.operation = Objects.requireNonNull(operation, "operation");
      initBits &= ~INIT_BIT_OPERATION;
      return this;
    }

    /**
     * Adds one element to {@link WriteDataRequest#idFieldNames() idFieldNames} list.
     * @param element A idFieldNames element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addIdFieldNames(String element) {
      if (this.idFieldNames == null) {
        this.idFieldNames = new ArrayList<String>();
      }
      this.idFieldNames.add(Objects.requireNonNull(element, "idFieldNames element"));
      return this;
    }

    /**
     * Adds elements to {@link WriteDataRequest#idFieldNames() idFieldNames} list.
     * @param elements An array of idFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addIdFieldNames(String... elements) {
      if (this.idFieldNames == null) {
        this.idFieldNames = new ArrayList<String>();
      }
      for (String element : elements) {
        this.idFieldNames.add(Objects.requireNonNull(element, "idFieldNames element"));
      }
      return this;
    }

    /**
     * Sets or replaces all elements for {@link WriteDataRequest#idFieldNames() idFieldNames} list.
     * @param elements An iterable of idFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder idFieldNames(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.idFieldNames = null;
        return this;
      }
      this.idFieldNames = new ArrayList<String>();
      return addAllIdFieldNames(elements);
    }

    /**
     * Adds elements to {@link WriteDataRequest#idFieldNames() idFieldNames} list.
     * @param elements An iterable of idFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllIdFieldNames(Iterable<String> elements) {
      Objects.requireNonNull(elements, "idFieldNames element");
      if (this.idFieldNames == null) {
        this.idFieldNames = new ArrayList<String>();
      }
      for (String element : elements) {
        this.idFieldNames.add(Objects.requireNonNull(element, "idFieldNames element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link WriteDataRequest#records() records} list.
     * @param element A records element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addRecords(String element) {
      if (this.records == null) {
        this.records = new ArrayList<String>();
      }
      this.records.add(Objects.requireNonNull(element, "records element"));
      return this;
    }

    /**
     * Adds elements to {@link WriteDataRequest#records() records} list.
     * @param elements An array of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addRecords(String... elements) {
      if (this.records == null) {
        this.records = new ArrayList<String>();
      }
      for (String element : elements) {
        this.records.add(Objects.requireNonNull(element, "records element"));
      }
      return this;
    }

    /**
     * Sets or replaces all elements for {@link WriteDataRequest#records() records} list.
     * @param elements An iterable of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder records(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.records = null;
        return this;
      }
      this.records = new ArrayList<String>();
      return addAllRecords(elements);
    }

    /**
     * Adds elements to {@link WriteDataRequest#records() records} list.
     * @param elements An iterable of records elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllRecords(Iterable<String> elements) {
      Objects.requireNonNull(elements, "records element");
      if (this.records == null) {
        this.records = new ArrayList<String>();
      }
      for (String element : elements) {
        this.records.add(Objects.requireNonNull(element, "records element"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link WriteDataRequest#allOrNone() allOrNone} attribute.
     * @param allOrNone The value for allOrNone (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder allOrNone(@Nullable Boolean allOrNone) {
      this.allOrNone = allOrNone;
      return this;
    }

    /**
     * Initializes the value for the {@link WriteDataRequest#connectorContext() connectorContext} attribute.
     * @param connectorContext The value for connectorContext 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorContext(ConnectorContext connectorContext) {
      this.connectorContext = Objects.requireNonNull(connectorContext, "connectorContext");
      initBits &= ~INIT_BIT_CONNECTOR_CONTEXT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableWriteDataRequest ImmutableWriteDataRequest}.
     * @return An immutable instance of WriteDataRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableWriteDataRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableWriteDataRequest(
          entityIdentifier,
          operation,
          idFieldNames == null ? null : createUnmodifiableList(true, idFieldNames),
          records == null ? null : createUnmodifiableList(true, records),
          allOrNone,
          connectorContext);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_ENTITY_IDENTIFIER) != 0) attributes.add("entityIdentifier");
      if ((initBits & INIT_BIT_OPERATION) != 0) attributes.add("operation");
      if ((initBits & INIT_BIT_CONNECTOR_CONTEXT) != 0) attributes.add("connectorContext");
      return "Cannot build WriteDataRequest, some of required attributes are not set " + attributes;
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
