package com.amazonaws.appflow.custom.connector.model.retreive;

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
 * Immutable implementation of {@link RetrieveDataRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableRetrieveDataRequest.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
@JsonTypeName("RetrieveDataRequest")
public final class ImmutableRetrieveDataRequest
    implements RetrieveDataRequest {
  private final String entityIdentifier;
  private final @Nullable List<String> selectedFieldNames;
  private final @Nullable String idFieldName;
  private final @Nullable List<String> ids;
  private final ConnectorContext connectorContext;

  private ImmutableRetrieveDataRequest(
      String entityIdentifier,
      @Nullable List<String> selectedFieldNames,
      @Nullable String idFieldName,
      @Nullable List<String> ids,
      ConnectorContext connectorContext) {
    this.entityIdentifier = entityIdentifier;
    this.selectedFieldNames = selectedFieldNames;
    this.idFieldName = idFieldName;
    this.ids = ids;
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
   * Field name which will be used as part of where statement to retrieve the data. Can be primary or any other column
   * name.
   */
  @JsonProperty("idFieldName")
  @Override
  public @Nullable String idFieldName() {
    return idFieldName;
  }

  /**
   * List of values for idFieldName.
   */
  @JsonProperty("ids")
  @Override
  public @Nullable List<String> ids() {
    return ids;
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
   * Copy the current immutable object by setting a value for the {@link RetrieveDataRequest#entityIdentifier() entityIdentifier} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param entityIdentifier A new value for entityIdentifier
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRetrieveDataRequest withEntityIdentifier(String entityIdentifier) {
    if (this.entityIdentifier.equals(entityIdentifier)) return this;
    String newValue = Objects.requireNonNull(entityIdentifier, "entityIdentifier");
    return new ImmutableRetrieveDataRequest(newValue, this.selectedFieldNames, this.idFieldName, this.ids, this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RetrieveDataRequest#selectedFieldNames() selectedFieldNames}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRetrieveDataRequest withSelectedFieldNames(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableRetrieveDataRequest(this.entityIdentifier, null, this.idFieldName, this.ids, this.connectorContext);
    }
    @Nullable List<String> newValue = Arrays.asList(elements) == null ? null : createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRetrieveDataRequest(this.entityIdentifier, newValue, this.idFieldName, this.ids, this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RetrieveDataRequest#selectedFieldNames() selectedFieldNames}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of selectedFieldNames elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRetrieveDataRequest withSelectedFieldNames(@Nullable Iterable<String> elements) {
    if (this.selectedFieldNames == elements) return this;
    @Nullable List<String> newValue = elements == null ? null : createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableRetrieveDataRequest(this.entityIdentifier, newValue, this.idFieldName, this.ids, this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RetrieveDataRequest#idFieldName() idFieldName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param idFieldName A new value for idFieldName (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRetrieveDataRequest withIdFieldName(@Nullable String idFieldName) {
    if (Objects.equals(this.idFieldName, idFieldName)) return this;
    return new ImmutableRetrieveDataRequest(this.entityIdentifier, this.selectedFieldNames, idFieldName, this.ids, this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RetrieveDataRequest#ids() ids}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRetrieveDataRequest withIds(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableRetrieveDataRequest(this.entityIdentifier, this.selectedFieldNames, this.idFieldName, null, this.connectorContext);
    }
    @Nullable List<String> newValue = Arrays.asList(elements) == null ? null : createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new ImmutableRetrieveDataRequest(
        this.entityIdentifier,
        this.selectedFieldNames,
        this.idFieldName,
        newValue,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link RetrieveDataRequest#ids() ids}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of ids elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableRetrieveDataRequest withIds(@Nullable Iterable<String> elements) {
    if (this.ids == elements) return this;
    @Nullable List<String> newValue = elements == null ? null : createUnmodifiableList(false, createSafeList(elements, true, false));
    return new ImmutableRetrieveDataRequest(
        this.entityIdentifier,
        this.selectedFieldNames,
        this.idFieldName,
        newValue,
        this.connectorContext);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link RetrieveDataRequest#connectorContext() connectorContext} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param connectorContext A new value for connectorContext
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableRetrieveDataRequest withConnectorContext(ConnectorContext connectorContext) {
    if (this.connectorContext == connectorContext) return this;
    ConnectorContext newValue = Objects.requireNonNull(connectorContext, "connectorContext");
    return new ImmutableRetrieveDataRequest(this.entityIdentifier, this.selectedFieldNames, this.idFieldName, this.ids, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableRetrieveDataRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableRetrieveDataRequest
        && equalTo((ImmutableRetrieveDataRequest) another);
  }

  private boolean equalTo(ImmutableRetrieveDataRequest another) {
    return entityIdentifier.equals(another.entityIdentifier)
        && Objects.equals(selectedFieldNames, another.selectedFieldNames)
        && Objects.equals(idFieldName, another.idFieldName)
        && Objects.equals(ids, another.ids)
        && connectorContext.equals(another.connectorContext);
  }

  /**
   * Computes a hash code from attributes: {@code entityIdentifier}, {@code selectedFieldNames}, {@code idFieldName}, {@code ids}, {@code connectorContext}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + entityIdentifier.hashCode();
    h = h * 17 + Objects.hashCode(selectedFieldNames);
    h = h * 17 + Objects.hashCode(idFieldName);
    h = h * 17 + Objects.hashCode(ids);
    h = h * 17 + connectorContext.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code RetrieveDataRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "RetrieveDataRequest{"
        + "entityIdentifier=" + entityIdentifier
        + ", selectedFieldNames=" + selectedFieldNames
        + ", idFieldName=" + idFieldName
        + ", ids=" + ids
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
  static final class Json implements RetrieveDataRequest {
    @Nullable String entityIdentifier;
    List<String> selectedFieldNames = null;
    @Nullable String idFieldName;
    List<String> ids = null;
    @Nullable ConnectorContext connectorContext;
    @JsonProperty("entityIdentifier")
    public void setEntityIdentifier(String entityIdentifier) {
      this.entityIdentifier = entityIdentifier;
    }
    @JsonProperty("selectedFieldNames")
    public void setSelectedFieldNames(@Nullable List<String> selectedFieldNames) {
      this.selectedFieldNames = selectedFieldNames;
    }
    @JsonProperty("idFieldName")
    public void setIdFieldName(@Nullable String idFieldName) {
      this.idFieldName = idFieldName;
    }
    @JsonProperty("ids")
    public void setIds(@Nullable List<String> ids) {
      this.ids = ids;
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
    public String idFieldName() { throw new UnsupportedOperationException(); }
    @Override
    public List<String> ids() { throw new UnsupportedOperationException(); }
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
  static ImmutableRetrieveDataRequest fromJson(Json json) {
    ImmutableRetrieveDataRequest.Builder builder = ImmutableRetrieveDataRequest.builder();
    if (json.entityIdentifier != null) {
      builder.entityIdentifier(json.entityIdentifier);
    }
    if (json.selectedFieldNames != null) {
      builder.addAllSelectedFieldNames(json.selectedFieldNames);
    }
    if (json.idFieldName != null) {
      builder.idFieldName(json.idFieldName);
    }
    if (json.ids != null) {
      builder.addAllIds(json.ids);
    }
    if (json.connectorContext != null) {
      builder.connectorContext(json.connectorContext);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link RetrieveDataRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable RetrieveDataRequest instance
   */
  public static ImmutableRetrieveDataRequest copyOf(RetrieveDataRequest instance) {
    if (instance instanceof ImmutableRetrieveDataRequest) {
      return (ImmutableRetrieveDataRequest) instance;
    }
    return ImmutableRetrieveDataRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableRetrieveDataRequest ImmutableRetrieveDataRequest}.
   * @return A new ImmutableRetrieveDataRequest builder
   */
  public static ImmutableRetrieveDataRequest.Builder builder() {
    return new ImmutableRetrieveDataRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableRetrieveDataRequest ImmutableRetrieveDataRequest}.
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
    private @Nullable String idFieldName;
    private List<String> ids = null;
    private @Nullable ConnectorContext connectorContext;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code RetrieveDataRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(RetrieveDataRequest instance) {
      Objects.requireNonNull(instance, "instance");
      entityIdentifier(instance.entityIdentifier());
      @Nullable List<String> selectedFieldNamesValue = instance.selectedFieldNames();
      if (selectedFieldNamesValue != null) {
        addAllSelectedFieldNames(selectedFieldNamesValue);
      }
      @Nullable String idFieldNameValue = instance.idFieldName();
      if (idFieldNameValue != null) {
        idFieldName(idFieldNameValue);
      }
      @Nullable List<String> idsValue = instance.ids();
      if (idsValue != null) {
        addAllIds(idsValue);
      }
      connectorContext(instance.connectorContext());
      return this;
    }

    /**
     * Initializes the value for the {@link RetrieveDataRequest#entityIdentifier() entityIdentifier} attribute.
     * @param entityIdentifier The value for entityIdentifier 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityIdentifier(String entityIdentifier) {
      this.entityIdentifier = Objects.requireNonNull(entityIdentifier, "entityIdentifier");
      initBits &= ~INIT_BIT_ENTITY_IDENTIFIER;
      return this;
    }

    /**
     * Adds one element to {@link RetrieveDataRequest#selectedFieldNames() selectedFieldNames} list.
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
     * Adds elements to {@link RetrieveDataRequest#selectedFieldNames() selectedFieldNames} list.
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
     * Sets or replaces all elements for {@link RetrieveDataRequest#selectedFieldNames() selectedFieldNames} list.
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
     * Adds elements to {@link RetrieveDataRequest#selectedFieldNames() selectedFieldNames} list.
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
     * Initializes the value for the {@link RetrieveDataRequest#idFieldName() idFieldName} attribute.
     * @param idFieldName The value for idFieldName (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder idFieldName(@Nullable String idFieldName) {
      this.idFieldName = idFieldName;
      return this;
    }

    /**
     * Adds one element to {@link RetrieveDataRequest#ids() ids} list.
     * @param element A ids element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addIds(String element) {
      if (this.ids == null) {
        this.ids = new ArrayList<String>();
      }
      this.ids.add(Objects.requireNonNull(element, "ids element"));
      return this;
    }

    /**
     * Adds elements to {@link RetrieveDataRequest#ids() ids} list.
     * @param elements An array of ids elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addIds(String... elements) {
      if (this.ids == null) {
        this.ids = new ArrayList<String>();
      }
      for (String element : elements) {
        this.ids.add(Objects.requireNonNull(element, "ids element"));
      }
      return this;
    }

    /**
     * Sets or replaces all elements for {@link RetrieveDataRequest#ids() ids} list.
     * @param elements An iterable of ids elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder ids(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.ids = null;
        return this;
      }
      this.ids = new ArrayList<String>();
      return addAllIds(elements);
    }

    /**
     * Adds elements to {@link RetrieveDataRequest#ids() ids} list.
     * @param elements An iterable of ids elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllIds(Iterable<String> elements) {
      Objects.requireNonNull(elements, "ids element");
      if (this.ids == null) {
        this.ids = new ArrayList<String>();
      }
      for (String element : elements) {
        this.ids.add(Objects.requireNonNull(element, "ids element"));
      }
      return this;
    }

    /**
     * Initializes the value for the {@link RetrieveDataRequest#connectorContext() connectorContext} attribute.
     * @param connectorContext The value for connectorContext 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder connectorContext(ConnectorContext connectorContext) {
      this.connectorContext = Objects.requireNonNull(connectorContext, "connectorContext");
      initBits &= ~INIT_BIT_CONNECTOR_CONTEXT;
      return this;
    }

    /**
     * Builds a new {@link ImmutableRetrieveDataRequest ImmutableRetrieveDataRequest}.
     * @return An immutable instance of RetrieveDataRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableRetrieveDataRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableRetrieveDataRequest(
          entityIdentifier,
          selectedFieldNames == null ? null : createUnmodifiableList(true, selectedFieldNames),
          idFieldName,
          ids == null ? null : createUnmodifiableList(true, ids),
          connectorContext);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_ENTITY_IDENTIFIER) != 0) attributes.add("entityIdentifier");
      if ((initBits & INIT_BIT_CONNECTOR_CONTEXT) != 0) attributes.add("connectorContext");
      return "Cannot build RetrieveDataRequest, some of required attributes are not set " + attributes;
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
