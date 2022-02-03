package com.amazonaws.appflow.custom.connector.example.query;

import com.amazonaws.appflow.custom.connector.model.metadata.EntityDefinition;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * Immutable implementation of {@link QueryObject}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableQueryObject.builder()}.
 */
@SuppressWarnings("all")
@ParametersAreNonnullByDefault
@Immutable
public final class ImmutableQueryObject
    implements QueryObject {
  private final String sObject;
  private final @Nullable ImmutableList<String> selectedFieldNames;
  private final @Nullable String filterExpression;
  private final @Nullable String idFieldName;
  private final @Nullable ImmutableList<String> fields;
  private final @Nullable String dataType;
  private final @Nullable EntityDefinition entityDefinition;

  private ImmutableQueryObject(
      String sObject,
      @Nullable ImmutableList<String> selectedFieldNames,
      @Nullable String filterExpression,
      @Nullable String idFieldName,
      @Nullable ImmutableList<String> fields,
      @Nullable String dataType,
      @Nullable EntityDefinition entityDefinition) {
    this.sObject = sObject;
    this.selectedFieldNames = selectedFieldNames;
    this.filterExpression = filterExpression;
    this.idFieldName = idFieldName;
    this.fields = fields;
    this.dataType = dataType;
    this.entityDefinition = entityDefinition;
  }

  /**
   * @return The value of the {@code sObject} attribute
   */
  @Override
  public String sObject() {
    return sObject;
  }

  /**
   * @return The value of the {@code selectedFieldNames} attribute
   */
  @Override
  public @Nullable ImmutableList<String> selectedFieldNames() {
    return selectedFieldNames;
  }

  /**
   * @return The value of the {@code filterExpression} attribute
   */
  @Override
  public @Nullable String filterExpression() {
    return filterExpression;
  }

  /**
   * @return The value of the {@code idFieldName} attribute
   */
  @Override
  public @Nullable String idFieldName() {
    return idFieldName;
  }

  /**
   * @return The value of the {@code fields} attribute
   */
  @Override
  public @Nullable ImmutableList<String> fields() {
    return fields;
  }

  /**
   * @return The value of the {@code dataType} attribute
   */
  @Override
  public @Nullable String dataType() {
    return dataType;
  }

  /**
   * @return The value of the {@code entityDefinition} attribute
   */
  @Override
  public @Nullable EntityDefinition entityDefinition() {
    return entityDefinition;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryObject#sObject() sObject} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param sObject A new value for sObject
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryObject withSObject(String sObject) {
    if (this.sObject.equals(sObject)) return this;
    String newValue = Preconditions.checkNotNull(sObject, "sObject");
    return new ImmutableQueryObject(
        newValue,
        this.selectedFieldNames,
        this.filterExpression,
        this.idFieldName,
        this.fields,
        this.dataType,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link QueryObject#selectedFieldNames() selectedFieldNames}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableQueryObject withSelectedFieldNames(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableQueryObject(
          this.sObject,
          null,
          this.filterExpression,
          this.idFieldName,
          this.fields,
          this.dataType,
          this.entityDefinition);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableQueryObject(
        this.sObject,
        newValue,
        this.filterExpression,
        this.idFieldName,
        this.fields,
        this.dataType,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link QueryObject#selectedFieldNames() selectedFieldNames}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of selectedFieldNames elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableQueryObject withSelectedFieldNames(@Nullable Iterable<String> elements) {
    if (this.selectedFieldNames == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableQueryObject(
        this.sObject,
        newValue,
        this.filterExpression,
        this.idFieldName,
        this.fields,
        this.dataType,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryObject#filterExpression() filterExpression} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param filterExpression A new value for filterExpression (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryObject withFilterExpression(@Nullable String filterExpression) {
    if (Objects.equal(this.filterExpression, filterExpression)) return this;
    return new ImmutableQueryObject(
        this.sObject,
        this.selectedFieldNames,
        filterExpression,
        this.idFieldName,
        this.fields,
        this.dataType,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryObject#idFieldName() idFieldName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param idFieldName A new value for idFieldName (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryObject withIdFieldName(@Nullable String idFieldName) {
    if (Objects.equal(this.idFieldName, idFieldName)) return this;
    return new ImmutableQueryObject(
        this.sObject,
        this.selectedFieldNames,
        this.filterExpression,
        idFieldName,
        this.fields,
        this.dataType,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link QueryObject#fields() fields}.
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableQueryObject withFields(@Nullable String... elements) {
    if (elements == null) {
      return new ImmutableQueryObject(
          this.sObject,
          this.selectedFieldNames,
          this.filterExpression,
          this.idFieldName,
          null,
          this.dataType,
          this.entityDefinition);
    }
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableQueryObject(
        this.sObject,
        this.selectedFieldNames,
        this.filterExpression,
        this.idFieldName,
        newValue,
        this.dataType,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link QueryObject#fields() fields}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param elements An iterable of fields elements to set
   * @return A modified copy of {@code this} object
   */
  public final ImmutableQueryObject withFields(@Nullable Iterable<String> elements) {
    if (this.fields == elements) return this;
    @Nullable ImmutableList<String> newValue = elements == null ? null : ImmutableList.copyOf(elements);
    return new ImmutableQueryObject(
        this.sObject,
        this.selectedFieldNames,
        this.filterExpression,
        this.idFieldName,
        newValue,
        this.dataType,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryObject#dataType() dataType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param dataType A new value for dataType (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryObject withDataType(@Nullable String dataType) {
    if (Objects.equal(this.dataType, dataType)) return this;
    return new ImmutableQueryObject(
        this.sObject,
        this.selectedFieldNames,
        this.filterExpression,
        this.idFieldName,
        this.fields,
        dataType,
        this.entityDefinition);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link QueryObject#entityDefinition() entityDefinition} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param entityDefinition A new value for entityDefinition (can be {@code null})
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableQueryObject withEntityDefinition(@Nullable EntityDefinition entityDefinition) {
    if (this.entityDefinition == entityDefinition) return this;
    return new ImmutableQueryObject(
        this.sObject,
        this.selectedFieldNames,
        this.filterExpression,
        this.idFieldName,
        this.fields,
        this.dataType,
        entityDefinition);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableQueryObject} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(@Nullable Object another) {
    if (this == another) return true;
    return another instanceof ImmutableQueryObject
        && equalTo((ImmutableQueryObject) another);
  }

  private boolean equalTo(ImmutableQueryObject another) {
    return sObject.equals(another.sObject)
        && Objects.equal(selectedFieldNames, another.selectedFieldNames)
        && Objects.equal(filterExpression, another.filterExpression)
        && Objects.equal(idFieldName, another.idFieldName)
        && Objects.equal(fields, another.fields)
        && Objects.equal(dataType, another.dataType)
        && Objects.equal(entityDefinition, another.entityDefinition);
  }

  /**
   * Computes a hash code from attributes: {@code sObject}, {@code selectedFieldNames}, {@code filterExpression}, {@code idFieldName}, {@code fields}, {@code dataType}, {@code entityDefinition}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + sObject.hashCode();
    h = h * 17 + Objects.hashCode(selectedFieldNames);
    h = h * 17 + Objects.hashCode(filterExpression);
    h = h * 17 + Objects.hashCode(idFieldName);
    h = h * 17 + Objects.hashCode(fields);
    h = h * 17 + Objects.hashCode(dataType);
    h = h * 17 + Objects.hashCode(entityDefinition);
    return h;
  }

  /**
   * Prints the immutable value {@code QueryObject} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return MoreObjects.toStringHelper("QueryObject")
        .omitNullValues()
        .add("sObject", sObject)
        .add("selectedFieldNames", selectedFieldNames)
        .add("filterExpression", filterExpression)
        .add("idFieldName", idFieldName)
        .add("fields", fields)
        .add("dataType", dataType)
        .add("entityDefinition", entityDefinition)
        .toString();
  }

  /**
   * Creates an immutable copy of a {@link QueryObject} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable QueryObject instance
   */
  public static ImmutableQueryObject copyOf(QueryObject instance) {
    if (instance instanceof ImmutableQueryObject) {
      return (ImmutableQueryObject) instance;
    }
    return ImmutableQueryObject.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableQueryObject ImmutableQueryObject}.
   * @return A new ImmutableQueryObject builder
   */
  public static ImmutableQueryObject.Builder builder() {
    return new ImmutableQueryObject.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableQueryObject ImmutableQueryObject}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @NotThreadSafe
  public static final class Builder {
    private static final long INIT_BIT_S_OBJECT = 0x1L;
    private long initBits = 0x1L;

    private @Nullable String sObject;
    private ImmutableList.Builder<String> selectedFieldNames = null;
    private @Nullable String filterExpression;
    private @Nullable String idFieldName;
    private ImmutableList.Builder<String> fields = null;
    private @Nullable String dataType;
    private @Nullable EntityDefinition entityDefinition;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code QueryObject} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(QueryObject instance) {
      Preconditions.checkNotNull(instance, "instance");
      sObject(instance.sObject());
      @Nullable List<String> selectedFieldNamesValue = instance.selectedFieldNames();
      if (selectedFieldNamesValue != null) {
        addAllSelectedFieldNames(selectedFieldNamesValue);
      }
      @Nullable String filterExpressionValue = instance.filterExpression();
      if (filterExpressionValue != null) {
        filterExpression(filterExpressionValue);
      }
      @Nullable String idFieldNameValue = instance.idFieldName();
      if (idFieldNameValue != null) {
        idFieldName(idFieldNameValue);
      }
      @Nullable List<String> fieldsValue = instance.fields();
      if (fieldsValue != null) {
        addAllFields(fieldsValue);
      }
      @Nullable String dataTypeValue = instance.dataType();
      if (dataTypeValue != null) {
        dataType(dataTypeValue);
      }
      @Nullable EntityDefinition entityDefinitionValue = instance.entityDefinition();
      if (entityDefinitionValue != null) {
        entityDefinition(entityDefinitionValue);
      }
      return this;
    }

    /**
     * Initializes the value for the {@link QueryObject#sObject() sObject} attribute.
     * @param sObject The value for sObject 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder sObject(String sObject) {
      this.sObject = Preconditions.checkNotNull(sObject, "sObject");
      initBits &= ~INIT_BIT_S_OBJECT;
      return this;
    }

    /**
     * Adds one element to {@link QueryObject#selectedFieldNames() selectedFieldNames} list.
     * @param element A selectedFieldNames element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSelectedFieldNames(String element) {
      if (this.selectedFieldNames == null) {
        this.selectedFieldNames = ImmutableList.builder();
      }
      this.selectedFieldNames.add(element);
      return this;
    }

    /**
     * Adds elements to {@link QueryObject#selectedFieldNames() selectedFieldNames} list.
     * @param elements An array of selectedFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addSelectedFieldNames(String... elements) {
      if (this.selectedFieldNames == null) {
        this.selectedFieldNames = ImmutableList.builder();
      }
      this.selectedFieldNames.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link QueryObject#selectedFieldNames() selectedFieldNames} list.
     * @param elements An iterable of selectedFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder selectedFieldNames(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.selectedFieldNames = null;
        return this;
      }
      this.selectedFieldNames = ImmutableList.builder();
      return addAllSelectedFieldNames(elements);
    }

    /**
     * Adds elements to {@link QueryObject#selectedFieldNames() selectedFieldNames} list.
     * @param elements An iterable of selectedFieldNames elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllSelectedFieldNames(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "selectedFieldNames element");
      if (this.selectedFieldNames == null) {
        this.selectedFieldNames = ImmutableList.builder();
      }
      this.selectedFieldNames.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link QueryObject#filterExpression() filterExpression} attribute.
     * @param filterExpression The value for filterExpression (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder filterExpression(@Nullable String filterExpression) {
      this.filterExpression = filterExpression;
      return this;
    }

    /**
     * Initializes the value for the {@link QueryObject#idFieldName() idFieldName} attribute.
     * @param idFieldName The value for idFieldName (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder idFieldName(@Nullable String idFieldName) {
      this.idFieldName = idFieldName;
      return this;
    }

    /**
     * Adds one element to {@link QueryObject#fields() fields} list.
     * @param element A fields element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addFields(String element) {
      if (this.fields == null) {
        this.fields = ImmutableList.builder();
      }
      this.fields.add(element);
      return this;
    }

    /**
     * Adds elements to {@link QueryObject#fields() fields} list.
     * @param elements An array of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addFields(String... elements) {
      if (this.fields == null) {
        this.fields = ImmutableList.builder();
      }
      this.fields.add(elements);
      return this;
    }

    /**
     * Sets or replaces all elements for {@link QueryObject#fields() fields} list.
     * @param elements An iterable of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder fields(@Nullable Iterable<String> elements) {
      if (elements == null) {
        this.fields = null;
        return this;
      }
      this.fields = ImmutableList.builder();
      return addAllFields(elements);
    }

    /**
     * Adds elements to {@link QueryObject#fields() fields} list.
     * @param elements An iterable of fields elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllFields(Iterable<String> elements) {
      Preconditions.checkNotNull(elements, "fields element");
      if (this.fields == null) {
        this.fields = ImmutableList.builder();
      }
      this.fields.addAll(elements);
      return this;
    }

    /**
     * Initializes the value for the {@link QueryObject#dataType() dataType} attribute.
     * @param dataType The value for dataType (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder dataType(@Nullable String dataType) {
      this.dataType = dataType;
      return this;
    }

    /**
     * Initializes the value for the {@link QueryObject#entityDefinition() entityDefinition} attribute.
     * @param entityDefinition The value for entityDefinition (can be {@code null})
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder entityDefinition(@Nullable EntityDefinition entityDefinition) {
      this.entityDefinition = entityDefinition;
      return this;
    }

    /**
     * Builds a new {@link ImmutableQueryObject ImmutableQueryObject}.
     * @return An immutable instance of QueryObject
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableQueryObject build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableQueryObject(
          sObject,
          selectedFieldNames == null ? null : selectedFieldNames.build(),
          filterExpression,
          idFieldName,
          fields == null ? null : fields.build(),
          dataType,
          entityDefinition);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = Lists.newArrayList();
      if ((initBits & INIT_BIT_S_OBJECT) != 0) attributes.add("sObject");
      return "Cannot build QueryObject, some of required attributes are not set " + attributes;
    }
  }
}
