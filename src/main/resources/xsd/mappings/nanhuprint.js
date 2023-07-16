var nanhuprint_Module_Factory = function () {
  var nanhuprint = {
    name: 'nanhuprint',
    defaultElementNamespaceURI: 'https:\/\/github.com\/hongjinqiu\/nanhu-print-java',
    typeInfos: [{
        localName: 'If.WhiteSpace',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Position',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Thead',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'tr',
                typeInfo: '.Tr'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'showPosition',
            attributeName: {
              localPart: 'showPosition'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Table',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'thead',
                typeInfo: '.Thead'
              }, {
                elementName: 'tbody',
                typeInfo: '.Tbody'
              }, {
                elementName: 'tloop',
                typeInfo: '.Tloop'
              }, {
                elementName: 'tbottom',
                typeInfo: '.Tbottom'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'explain',
            attributeName: {
              localPart: 'explain'
            },
            type: 'attribute'
          }, {
            name: 'cls',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cls'
            },
            type: 'attribute'
          }, {
            name: 'width',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'width'
            },
            type: 'attribute'
          }, {
            name: 'height',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'height'
            },
            type: 'attribute'
          }, {
            name: 'paddingLeft',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingLeft'
            },
            type: 'attribute'
          }, {
            name: 'paddingTop',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingTop'
            },
            type: 'attribute'
          }, {
            name: 'paddingRight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingRight'
            },
            type: 'attribute'
          }, {
            name: 'paddingBottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingBottom'
            },
            type: 'attribute'
          }, {
            name: 'marginLeftByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginLeftByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginTopByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginTopByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginRightByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginRightByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginBottomByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginBottomByJs'
            },
            type: 'attribute'
          }, {
            name: 'fontFamily',
            attributeName: {
              localPart: 'fontFamily'
            },
            type: 'attribute'
          }, {
            name: 'fontStyle',
            attributeName: {
              localPart: 'fontStyle'
            },
            type: 'attribute'
          }, {
            name: 'fontWeight',
            attributeName: {
              localPart: 'fontWeight'
            },
            type: 'attribute'
          }, {
            name: 'textDecoration',
            attributeName: {
              localPart: 'textDecoration'
            },
            type: 'attribute'
          }, {
            name: 'borderCollapse',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderCollapse'
            },
            type: 'attribute'
          }, {
            name: 'borderSpacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderSpacing'
            },
            type: 'attribute'
          }, {
            name: 'tableLayout',
            attributeName: {
              localPart: 'tableLayout'
            },
            type: 'attribute'
          }, {
            name: 'textAlign',
            attributeName: {
              localPart: 'textAlign'
            },
            type: 'attribute'
          }, {
            name: 'whiteSpace',
            attributeName: {
              localPart: 'whiteSpace'
            },
            type: 'attribute'
          }, {
            name: 'wordWrap',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'wordWrap'
            },
            type: 'attribute'
          }, {
            name: 'display',
            attributeName: {
              localPart: 'display'
            },
            type: 'attribute'
          }, {
            name: 'visibility',
            attributeName: {
              localPart: 'visibility'
            },
            type: 'attribute'
          }, {
            name: 'clear',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'clear'
            },
            type: 'attribute'
          }, {
            name: 'zoom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zoom'
            },
            type: 'attribute'
          }, {
            name: 'floatAlign',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'floatAlign'
            },
            type: 'attribute'
          }, {
            name: 'fontSize',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'fontSize'
            },
            type: 'attribute'
          }, {
            name: 'webkitBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'webkitBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'mozBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'mozBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'boxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'boxSizing'
            },
            type: 'attribute'
          }, {
            name: 'minHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'minHeight'
            },
            type: 'attribute'
          }, {
            name: 'position',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'position'
            },
            type: 'attribute'
          }, {
            name: 'lineHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'lineHeight'
            },
            type: 'attribute'
          }, {
            name: 'color',
            attributeName: {
              localPart: 'color'
            },
            type: 'attribute'
          }, {
            name: 'borderTopWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderTopWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderTopStyle',
            attributeName: {
              localPart: 'borderTopStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderTopColor',
            attributeName: {
              localPart: 'borderTopColor'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderLeftWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftStyle',
            attributeName: {
              localPart: 'borderLeftStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftColor',
            attributeName: {
              localPart: 'borderLeftColor'
            },
            type: 'attribute'
          }, {
            name: 'borderRightWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderRightWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderRightStyle',
            attributeName: {
              localPart: 'borderRightStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderRightColor',
            attributeName: {
              localPart: 'borderRightColor'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderBottomWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomStyle',
            attributeName: {
              localPart: 'borderBottomStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomColor',
            attributeName: {
              localPart: 'borderBottomColor'
            },
            type: 'attribute'
          }, {
            name: 'maxWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxWidth'
            },
            type: 'attribute'
          }, {
            name: 'left',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'left'
            },
            type: 'attribute'
          }, {
            name: 'top',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'top'
            },
            type: 'attribute'
          }, {
            name: 'right',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'right'
            },
            type: 'attribute'
          }, {
            name: 'bottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'bottom'
            },
            type: 'attribute'
          }, {
            name: 'verticalAlign',
            attributeName: {
              localPart: 'verticalAlign'
            },
            type: 'attribute'
          }, {
            name: 'overflowX',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowX'
            },
            type: 'attribute'
          }, {
            name: 'overflowY',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowY'
            },
            type: 'attribute'
          }, {
            name: 'maxHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxHeight'
            },
            type: 'attribute'
          }, {
            name: 'backgroundColor',
            attributeName: {
              localPart: 'backgroundColor'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImage',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImage'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImageOpacityByPdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImageOpacityByPdf'
            },
            type: 'attribute'
          }, {
            name: 'backgroundSize',
            attributeName: {
              localPart: 'backgroundSize'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionX',
            attributeName: {
              localPart: 'backgroundPositionX'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionY',
            attributeName: {
              localPart: 'backgroundPositionY'
            },
            type: 'attribute'
          }, {
            name: 'transformByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'transformByJs'
            },
            type: 'attribute'
          }, {
            name: 'opacityByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'opacityByJs'
            },
            type: 'attribute'
          }, {
            name: 'zIndexByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zIndexByJs'
            },
            type: 'attribute'
          }, {
            name: 'backgroundRepeatByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundRepeatByJs'
            },
            type: 'attribute'
          }, {
            name: 'cellspacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellspacing'
            },
            type: 'attribute'
          }, {
            name: 'cellpadding',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellpadding'
            },
            type: 'attribute'
          }, {
            name: 'colspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'colspan'
            },
            type: 'attribute'
          }, {
            name: 'rowspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'rowspan'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BackgroundPositionY',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.MinHeight',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Th',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'table',
                typeInfo: '.Table'
              }, {
                elementName: 'div',
                typeInfo: '.Div'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'span',
                typeInfo: '.Span'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'scaleToFitContentByPdf',
            attributeName: {
              localPart: 'scaleToFitContentByPdf'
            },
            type: 'attribute'
          }, {
            name: 'explain',
            attributeName: {
              localPart: 'explain'
            },
            type: 'attribute'
          }, {
            name: 'cls',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cls'
            },
            type: 'attribute'
          }, {
            name: 'width',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'width'
            },
            type: 'attribute'
          }, {
            name: 'height',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'height'
            },
            type: 'attribute'
          }, {
            name: 'paddingLeft',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingLeft'
            },
            type: 'attribute'
          }, {
            name: 'paddingTop',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingTop'
            },
            type: 'attribute'
          }, {
            name: 'paddingRight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingRight'
            },
            type: 'attribute'
          }, {
            name: 'paddingBottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingBottom'
            },
            type: 'attribute'
          }, {
            name: 'marginLeftByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginLeftByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginTopByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginTopByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginRightByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginRightByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginBottomByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginBottomByJs'
            },
            type: 'attribute'
          }, {
            name: 'fontFamily',
            attributeName: {
              localPart: 'fontFamily'
            },
            type: 'attribute'
          }, {
            name: 'fontStyle',
            attributeName: {
              localPart: 'fontStyle'
            },
            type: 'attribute'
          }, {
            name: 'fontWeight',
            attributeName: {
              localPart: 'fontWeight'
            },
            type: 'attribute'
          }, {
            name: 'textDecoration',
            attributeName: {
              localPart: 'textDecoration'
            },
            type: 'attribute'
          }, {
            name: 'borderCollapse',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderCollapse'
            },
            type: 'attribute'
          }, {
            name: 'borderSpacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderSpacing'
            },
            type: 'attribute'
          }, {
            name: 'tableLayout',
            attributeName: {
              localPart: 'tableLayout'
            },
            type: 'attribute'
          }, {
            name: 'textAlign',
            attributeName: {
              localPart: 'textAlign'
            },
            type: 'attribute'
          }, {
            name: 'whiteSpace',
            attributeName: {
              localPart: 'whiteSpace'
            },
            type: 'attribute'
          }, {
            name: 'wordWrap',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'wordWrap'
            },
            type: 'attribute'
          }, {
            name: 'display',
            attributeName: {
              localPart: 'display'
            },
            type: 'attribute'
          }, {
            name: 'visibility',
            attributeName: {
              localPart: 'visibility'
            },
            type: 'attribute'
          }, {
            name: 'clear',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'clear'
            },
            type: 'attribute'
          }, {
            name: 'zoom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zoom'
            },
            type: 'attribute'
          }, {
            name: 'floatAlign',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'floatAlign'
            },
            type: 'attribute'
          }, {
            name: 'fontSize',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'fontSize'
            },
            type: 'attribute'
          }, {
            name: 'webkitBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'webkitBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'mozBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'mozBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'boxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'boxSizing'
            },
            type: 'attribute'
          }, {
            name: 'minHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'minHeight'
            },
            type: 'attribute'
          }, {
            name: 'position',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'position'
            },
            type: 'attribute'
          }, {
            name: 'lineHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'lineHeight'
            },
            type: 'attribute'
          }, {
            name: 'color',
            attributeName: {
              localPart: 'color'
            },
            type: 'attribute'
          }, {
            name: 'borderTopWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderTopWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderTopStyle',
            attributeName: {
              localPart: 'borderTopStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderTopColor',
            attributeName: {
              localPart: 'borderTopColor'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderLeftWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftStyle',
            attributeName: {
              localPart: 'borderLeftStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftColor',
            attributeName: {
              localPart: 'borderLeftColor'
            },
            type: 'attribute'
          }, {
            name: 'borderRightWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderRightWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderRightStyle',
            attributeName: {
              localPart: 'borderRightStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderRightColor',
            attributeName: {
              localPart: 'borderRightColor'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderBottomWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomStyle',
            attributeName: {
              localPart: 'borderBottomStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomColor',
            attributeName: {
              localPart: 'borderBottomColor'
            },
            type: 'attribute'
          }, {
            name: 'maxWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxWidth'
            },
            type: 'attribute'
          }, {
            name: 'left',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'left'
            },
            type: 'attribute'
          }, {
            name: 'top',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'top'
            },
            type: 'attribute'
          }, {
            name: 'right',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'right'
            },
            type: 'attribute'
          }, {
            name: 'bottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'bottom'
            },
            type: 'attribute'
          }, {
            name: 'verticalAlign',
            attributeName: {
              localPart: 'verticalAlign'
            },
            type: 'attribute'
          }, {
            name: 'overflowX',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowX'
            },
            type: 'attribute'
          }, {
            name: 'overflowY',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowY'
            },
            type: 'attribute'
          }, {
            name: 'maxHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxHeight'
            },
            type: 'attribute'
          }, {
            name: 'backgroundColor',
            attributeName: {
              localPart: 'backgroundColor'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImage',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImage'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImageOpacityByPdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImageOpacityByPdf'
            },
            type: 'attribute'
          }, {
            name: 'backgroundSize',
            attributeName: {
              localPart: 'backgroundSize'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionX',
            attributeName: {
              localPart: 'backgroundPositionX'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionY',
            attributeName: {
              localPart: 'backgroundPositionY'
            },
            type: 'attribute'
          }, {
            name: 'transformByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'transformByJs'
            },
            type: 'attribute'
          }, {
            name: 'opacityByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'opacityByJs'
            },
            type: 'attribute'
          }, {
            name: 'zIndexByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zIndexByJs'
            },
            type: 'attribute'
          }, {
            name: 'backgroundRepeatByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundRepeatByJs'
            },
            type: 'attribute'
          }, {
            name: 'cellspacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellspacing'
            },
            type: 'attribute'
          }, {
            name: 'cellpadding',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellpadding'
            },
            type: 'attribute'
          }, {
            name: 'colspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'colspan'
            },
            type: 'attribute'
          }, {
            name: 'rowspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'rowspan'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Clear',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.MarginRightByJs',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.OverflowX',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Tbottom',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'tr',
                typeInfo: '.Tr'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'showPosition',
            attributeName: {
              localPart: 'showPosition'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.FontStyle',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.VerticalAlign',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Display',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.PaddingBottom',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderLeftStyle',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BackgroundPositionX',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.MarginLeftByJs',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BoxSizing',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.MaxWidth',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Left',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderLeftColor',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Body',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'table',
                typeInfo: '.Table'
              }, {
                elementName: 'div',
                typeInfo: '.Div'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'span',
                typeInfo: '.Span'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'pageSizePdf',
            attributeName: {
              localPart: 'pageSizePdf'
            },
            type: 'attribute'
          }, {
            name: 'explain',
            attributeName: {
              localPart: 'explain'
            },
            type: 'attribute'
          }, {
            name: 'rotate',
            attributeName: {
              localPart: 'rotate'
            },
            type: 'attribute'
          }, {
            name: 'cls',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cls'
            },
            type: 'attribute'
          }, {
            name: 'width',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'width'
            },
            type: 'attribute'
          }, {
            name: 'height',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'height'
            },
            type: 'attribute'
          }, {
            name: 'paddingLeft',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingLeft'
            },
            type: 'attribute'
          }, {
            name: 'paddingTop',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingTop'
            },
            type: 'attribute'
          }, {
            name: 'paddingRight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingRight'
            },
            type: 'attribute'
          }, {
            name: 'paddingBottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingBottom'
            },
            type: 'attribute'
          }, {
            name: 'marginLeftByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginLeftByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginTopByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginTopByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginRightByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginRightByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginBottomByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginBottomByJs'
            },
            type: 'attribute'
          }, {
            name: 'fontFamily',
            attributeName: {
              localPart: 'fontFamily'
            },
            type: 'attribute'
          }, {
            name: 'fontStyle',
            attributeName: {
              localPart: 'fontStyle'
            },
            type: 'attribute'
          }, {
            name: 'fontWeight',
            attributeName: {
              localPart: 'fontWeight'
            },
            type: 'attribute'
          }, {
            name: 'textDecoration',
            attributeName: {
              localPart: 'textDecoration'
            },
            type: 'attribute'
          }, {
            name: 'borderCollapse',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderCollapse'
            },
            type: 'attribute'
          }, {
            name: 'borderSpacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderSpacing'
            },
            type: 'attribute'
          }, {
            name: 'tableLayout',
            attributeName: {
              localPart: 'tableLayout'
            },
            type: 'attribute'
          }, {
            name: 'textAlign',
            attributeName: {
              localPart: 'textAlign'
            },
            type: 'attribute'
          }, {
            name: 'whiteSpace',
            attributeName: {
              localPart: 'whiteSpace'
            },
            type: 'attribute'
          }, {
            name: 'wordWrap',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'wordWrap'
            },
            type: 'attribute'
          }, {
            name: 'display',
            attributeName: {
              localPart: 'display'
            },
            type: 'attribute'
          }, {
            name: 'visibility',
            attributeName: {
              localPart: 'visibility'
            },
            type: 'attribute'
          }, {
            name: 'clear',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'clear'
            },
            type: 'attribute'
          }, {
            name: 'zoom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zoom'
            },
            type: 'attribute'
          }, {
            name: 'floatAlign',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'floatAlign'
            },
            type: 'attribute'
          }, {
            name: 'fontSize',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'fontSize'
            },
            type: 'attribute'
          }, {
            name: 'webkitBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'webkitBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'mozBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'mozBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'boxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'boxSizing'
            },
            type: 'attribute'
          }, {
            name: 'minHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'minHeight'
            },
            type: 'attribute'
          }, {
            name: 'position',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'position'
            },
            type: 'attribute'
          }, {
            name: 'lineHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'lineHeight'
            },
            type: 'attribute'
          }, {
            name: 'color',
            attributeName: {
              localPart: 'color'
            },
            type: 'attribute'
          }, {
            name: 'borderTopWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderTopWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderTopStyle',
            attributeName: {
              localPart: 'borderTopStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderTopColor',
            attributeName: {
              localPart: 'borderTopColor'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderLeftWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftStyle',
            attributeName: {
              localPart: 'borderLeftStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftColor',
            attributeName: {
              localPart: 'borderLeftColor'
            },
            type: 'attribute'
          }, {
            name: 'borderRightWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderRightWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderRightStyle',
            attributeName: {
              localPart: 'borderRightStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderRightColor',
            attributeName: {
              localPart: 'borderRightColor'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderBottomWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomStyle',
            attributeName: {
              localPart: 'borderBottomStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomColor',
            attributeName: {
              localPart: 'borderBottomColor'
            },
            type: 'attribute'
          }, {
            name: 'maxWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxWidth'
            },
            type: 'attribute'
          }, {
            name: 'left',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'left'
            },
            type: 'attribute'
          }, {
            name: 'top',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'top'
            },
            type: 'attribute'
          }, {
            name: 'right',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'right'
            },
            type: 'attribute'
          }, {
            name: 'bottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'bottom'
            },
            type: 'attribute'
          }, {
            name: 'verticalAlign',
            attributeName: {
              localPart: 'verticalAlign'
            },
            type: 'attribute'
          }, {
            name: 'overflowX',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowX'
            },
            type: 'attribute'
          }, {
            name: 'overflowY',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowY'
            },
            type: 'attribute'
          }, {
            name: 'maxHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxHeight'
            },
            type: 'attribute'
          }, {
            name: 'backgroundColor',
            attributeName: {
              localPart: 'backgroundColor'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImage',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImage'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImageOpacityByPdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImageOpacityByPdf'
            },
            type: 'attribute'
          }, {
            name: 'backgroundSize',
            attributeName: {
              localPart: 'backgroundSize'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionX',
            attributeName: {
              localPart: 'backgroundPositionX'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionY',
            attributeName: {
              localPart: 'backgroundPositionY'
            },
            type: 'attribute'
          }, {
            name: 'transformByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'transformByJs'
            },
            type: 'attribute'
          }, {
            name: 'opacityByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'opacityByJs'
            },
            type: 'attribute'
          }, {
            name: 'zIndexByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zIndexByJs'
            },
            type: 'attribute'
          }, {
            name: 'backgroundRepeatByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundRepeatByJs'
            },
            type: 'attribute'
          }, {
            name: 'cellspacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellspacing'
            },
            type: 'attribute'
          }, {
            name: 'cellpadding',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellpadding'
            },
            type: 'attribute'
          }, {
            name: 'colspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'colspan'
            },
            type: 'attribute'
          }, {
            name: 'rowspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'rowspan'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderBottomColor',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.FontSize',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Top',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.PaddingTop',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.TableLayout',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Set',
        typeName: null,
        propertyInfos: [{
            name: 'var',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'var'
            },
            type: 'attribute'
          }, {
            name: 'valueJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'valueJs'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderTopWidth',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Width',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderBottomWidth',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderRightWidth',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.FloatAlign',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderTopStyle',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Color',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Tloop',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'tr',
                typeInfo: '.Tr'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'countJs',
            typeInfo: 'Int',
            attributeName: {
              localPart: 'countJs'
            },
            type: 'attribute'
          }, {
            name: 'mode',
            attributeName: {
              localPart: 'mode'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderLeftWidth',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Macro',
        typeName: null,
        propertyInfos: [{
            name: 'widthAndHeightAndPaddingLeft',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'width',
                typeInfo: '.If.Width'
              }, {
                elementName: 'height',
                typeInfo: '.If.Height'
              }, {
                elementName: 'paddingLeft',
                typeInfo: '.If.PaddingLeft'
              }, {
                elementName: 'paddingTop',
                typeInfo: '.If.PaddingTop'
              }, {
                elementName: 'paddingRight',
                typeInfo: '.If.PaddingRight'
              }, {
                elementName: 'paddingBottom',
                typeInfo: '.If.PaddingBottom'
              }, {
                elementName: 'marginLeftByJs',
                typeInfo: '.If.MarginLeftByJs'
              }, {
                elementName: 'marginTopByJs',
                typeInfo: '.If.MarginTopByJs'
              }, {
                elementName: 'marginRightByJs',
                typeInfo: '.If.MarginRightByJs'
              }, {
                elementName: 'marginBottomByJs',
                typeInfo: '.If.MarginBottomByJs'
              }, {
                elementName: 'fontFamily',
                typeInfo: '.If.FontFamily'
              }, {
                elementName: 'fontStyle',
                typeInfo: '.If.FontStyle'
              }, {
                elementName: 'fontWeight',
                typeInfo: '.If.FontWeight'
              }, {
                elementName: 'textDecoration',
                typeInfo: '.If.TextDecoration'
              }, {
                elementName: 'borderCollapse',
                typeInfo: '.If.BorderCollapse'
              }, {
                elementName: 'borderSpacing',
                typeInfo: '.If.BorderSpacing'
              }, {
                elementName: 'tableLayout',
                typeInfo: '.If.TableLayout'
              }, {
                elementName: 'textAlign',
                typeInfo: '.If.TextAlign'
              }, {
                elementName: 'whiteSpace',
                typeInfo: '.If.WhiteSpace'
              }, {
                elementName: 'wordWrap',
                typeInfo: '.If.WordWrap'
              }, {
                elementName: 'display',
                typeInfo: '.If.Display'
              }, {
                elementName: 'visibility',
                typeInfo: '.If.Visibility'
              }, {
                elementName: 'clear',
                typeInfo: '.If.Clear'
              }, {
                elementName: 'zoom',
                typeInfo: '.If.Zoom'
              }, {
                elementName: 'floatAlign',
                typeInfo: '.If.FloatAlign'
              }, {
                elementName: 'fontSize',
                typeInfo: '.If.FontSize'
              }, {
                elementName: 'webkitBoxSizing',
                typeInfo: '.If.WebkitBoxSizing'
              }, {
                elementName: 'mozBoxSizing',
                typeInfo: '.If.MozBoxSizing'
              }, {
                elementName: 'boxSizing',
                typeInfo: '.If.BoxSizing'
              }, {
                elementName: 'minHeight',
                typeInfo: '.If.MinHeight'
              }, {
                elementName: 'position',
                typeInfo: '.If.Position'
              }, {
                elementName: 'lineHeight',
                typeInfo: '.If.LineHeight'
              }, {
                elementName: 'color',
                typeInfo: '.If.Color'
              }, {
                elementName: 'borderTopWidth',
                typeInfo: '.If.BorderTopWidth'
              }, {
                elementName: 'borderTopStyle',
                typeInfo: '.If.BorderTopStyle'
              }, {
                elementName: 'borderTopColor',
                typeInfo: '.If.BorderTopColor'
              }, {
                elementName: 'borderLeftWidth',
                typeInfo: '.If.BorderLeftWidth'
              }, {
                elementName: 'borderLeftStyle',
                typeInfo: '.If.BorderLeftStyle'
              }, {
                elementName: 'borderLeftColor',
                typeInfo: '.If.BorderLeftColor'
              }, {
                elementName: 'borderRightWidth',
                typeInfo: '.If.BorderRightWidth'
              }, {
                elementName: 'borderRightStyle',
                typeInfo: '.If.BorderRightStyle'
              }, {
                elementName: 'borderRightColor',
                typeInfo: '.If.BorderRightColor'
              }, {
                elementName: 'borderBottomWidth',
                typeInfo: '.If.BorderBottomWidth'
              }, {
                elementName: 'borderBottomStyle',
                typeInfo: '.If.BorderBottomStyle'
              }, {
                elementName: 'borderBottomColor',
                typeInfo: '.If.BorderBottomColor'
              }, {
                elementName: 'maxWidth',
                typeInfo: '.If.MaxWidth'
              }, {
                elementName: 'left',
                typeInfo: '.If.Left'
              }, {
                elementName: 'top',
                typeInfo: '.If.Top'
              }, {
                elementName: 'right',
                typeInfo: '.If.Right'
              }, {
                elementName: 'bottom',
                typeInfo: '.If.Bottom'
              }, {
                elementName: 'verticalAlign',
                typeInfo: '.If.VerticalAlign'
              }, {
                elementName: 'overflowX',
                typeInfo: '.If.OverflowX'
              }, {
                elementName: 'overflowY',
                typeInfo: '.If.OverflowY'
              }, {
                elementName: 'maxHeight',
                typeInfo: '.If.MaxHeight'
              }, {
                elementName: 'backgroundColor',
                typeInfo: '.If.BackgroundColor'
              }, {
                elementName: 'backgroundImage',
                typeInfo: '.If.BackgroundImage'
              }, {
                elementName: 'backgroundImageOpacityByPdf',
                typeInfo: '.If.BackgroundImageOpacityByPdf'
              }, {
                elementName: 'backgroundSize',
                typeInfo: '.If.BackgroundSize'
              }, {
                elementName: 'backgroundPositionX',
                typeInfo: '.If.BackgroundPositionX'
              }, {
                elementName: 'backgroundPositionY',
                typeInfo: '.If.BackgroundPositionY'
              }, {
                elementName: 'transformByJs',
                typeInfo: '.If.TransformByJs'
              }, {
                elementName: 'opacityByJs',
                typeInfo: '.If.OpacityByJs'
              }, {
                elementName: 'zIndexByJs',
                typeInfo: '.If.ZIndexByJs'
              }, {
                elementName: 'backgroundRepeatByJs',
                typeInfo: '.If.BackgroundRepeatByJs'
              }, {
                elementName: 'table',
                typeInfo: '.Table'
              }, {
                elementName: 'thead',
                typeInfo: '.Thead'
              }, {
                elementName: 'tr',
                typeInfo: '.Tr'
              }, {
                elementName: 'tbody',
                typeInfo: '.Tbody'
              }, {
                elementName: 'tloop',
                typeInfo: '.Tloop'
              }, {
                elementName: 'tbottom',
                typeInfo: '.Tbottom'
              }, {
                elementName: 'th',
                typeInfo: '.Th'
              }, {
                elementName: 'td',
                typeInfo: '.Td'
              }, {
                elementName: 'div',
                typeInfo: '.Div'
              }, {
                elementName: 'span',
                typeInfo: '.Span'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }],
            type: 'elements'
          }, {
            name: 'name',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'name'
            },
            type: 'attribute'
          }, {
            name: 'paramJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paramJs'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.WebkitBoxSizing',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Visibility',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.ZIndexByJs',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Right',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.TransformByJs',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderBottomStyle',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.FontWeight',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BackgroundImage',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderRightColor',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.MarginBottomByJs',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'ForEach',
        typeName: null,
        propertyInfos: [{
            name: 'widthAndHeightAndPaddingLeft',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'width',
                typeInfo: '.If.Width'
              }, {
                elementName: 'height',
                typeInfo: '.If.Height'
              }, {
                elementName: 'paddingLeft',
                typeInfo: '.If.PaddingLeft'
              }, {
                elementName: 'paddingTop',
                typeInfo: '.If.PaddingTop'
              }, {
                elementName: 'paddingRight',
                typeInfo: '.If.PaddingRight'
              }, {
                elementName: 'paddingBottom',
                typeInfo: '.If.PaddingBottom'
              }, {
                elementName: 'marginLeftByJs',
                typeInfo: '.If.MarginLeftByJs'
              }, {
                elementName: 'marginTopByJs',
                typeInfo: '.If.MarginTopByJs'
              }, {
                elementName: 'marginRightByJs',
                typeInfo: '.If.MarginRightByJs'
              }, {
                elementName: 'marginBottomByJs',
                typeInfo: '.If.MarginBottomByJs'
              }, {
                elementName: 'fontFamily',
                typeInfo: '.If.FontFamily'
              }, {
                elementName: 'fontStyle',
                typeInfo: '.If.FontStyle'
              }, {
                elementName: 'fontWeight',
                typeInfo: '.If.FontWeight'
              }, {
                elementName: 'textDecoration',
                typeInfo: '.If.TextDecoration'
              }, {
                elementName: 'borderCollapse',
                typeInfo: '.If.BorderCollapse'
              }, {
                elementName: 'borderSpacing',
                typeInfo: '.If.BorderSpacing'
              }, {
                elementName: 'tableLayout',
                typeInfo: '.If.TableLayout'
              }, {
                elementName: 'textAlign',
                typeInfo: '.If.TextAlign'
              }, {
                elementName: 'whiteSpace',
                typeInfo: '.If.WhiteSpace'
              }, {
                elementName: 'wordWrap',
                typeInfo: '.If.WordWrap'
              }, {
                elementName: 'display',
                typeInfo: '.If.Display'
              }, {
                elementName: 'visibility',
                typeInfo: '.If.Visibility'
              }, {
                elementName: 'clear',
                typeInfo: '.If.Clear'
              }, {
                elementName: 'zoom',
                typeInfo: '.If.Zoom'
              }, {
                elementName: 'floatAlign',
                typeInfo: '.If.FloatAlign'
              }, {
                elementName: 'fontSize',
                typeInfo: '.If.FontSize'
              }, {
                elementName: 'webkitBoxSizing',
                typeInfo: '.If.WebkitBoxSizing'
              }, {
                elementName: 'mozBoxSizing',
                typeInfo: '.If.MozBoxSizing'
              }, {
                elementName: 'boxSizing',
                typeInfo: '.If.BoxSizing'
              }, {
                elementName: 'minHeight',
                typeInfo: '.If.MinHeight'
              }, {
                elementName: 'position',
                typeInfo: '.If.Position'
              }, {
                elementName: 'lineHeight',
                typeInfo: '.If.LineHeight'
              }, {
                elementName: 'color',
                typeInfo: '.If.Color'
              }, {
                elementName: 'borderTopWidth',
                typeInfo: '.If.BorderTopWidth'
              }, {
                elementName: 'borderTopStyle',
                typeInfo: '.If.BorderTopStyle'
              }, {
                elementName: 'borderTopColor',
                typeInfo: '.If.BorderTopColor'
              }, {
                elementName: 'borderLeftWidth',
                typeInfo: '.If.BorderLeftWidth'
              }, {
                elementName: 'borderLeftStyle',
                typeInfo: '.If.BorderLeftStyle'
              }, {
                elementName: 'borderLeftColor',
                typeInfo: '.If.BorderLeftColor'
              }, {
                elementName: 'borderRightWidth',
                typeInfo: '.If.BorderRightWidth'
              }, {
                elementName: 'borderRightStyle',
                typeInfo: '.If.BorderRightStyle'
              }, {
                elementName: 'borderRightColor',
                typeInfo: '.If.BorderRightColor'
              }, {
                elementName: 'borderBottomWidth',
                typeInfo: '.If.BorderBottomWidth'
              }, {
                elementName: 'borderBottomStyle',
                typeInfo: '.If.BorderBottomStyle'
              }, {
                elementName: 'borderBottomColor',
                typeInfo: '.If.BorderBottomColor'
              }, {
                elementName: 'maxWidth',
                typeInfo: '.If.MaxWidth'
              }, {
                elementName: 'left',
                typeInfo: '.If.Left'
              }, {
                elementName: 'top',
                typeInfo: '.If.Top'
              }, {
                elementName: 'right',
                typeInfo: '.If.Right'
              }, {
                elementName: 'bottom',
                typeInfo: '.If.Bottom'
              }, {
                elementName: 'verticalAlign',
                typeInfo: '.If.VerticalAlign'
              }, {
                elementName: 'overflowX',
                typeInfo: '.If.OverflowX'
              }, {
                elementName: 'overflowY',
                typeInfo: '.If.OverflowY'
              }, {
                elementName: 'maxHeight',
                typeInfo: '.If.MaxHeight'
              }, {
                elementName: 'backgroundColor',
                typeInfo: '.If.BackgroundColor'
              }, {
                elementName: 'backgroundImage',
                typeInfo: '.If.BackgroundImage'
              }, {
                elementName: 'backgroundImageOpacityByPdf',
                typeInfo: '.If.BackgroundImageOpacityByPdf'
              }, {
                elementName: 'backgroundSize',
                typeInfo: '.If.BackgroundSize'
              }, {
                elementName: 'backgroundPositionX',
                typeInfo: '.If.BackgroundPositionX'
              }, {
                elementName: 'backgroundPositionY',
                typeInfo: '.If.BackgroundPositionY'
              }, {
                elementName: 'transformByJs',
                typeInfo: '.If.TransformByJs'
              }, {
                elementName: 'opacityByJs',
                typeInfo: '.If.OpacityByJs'
              }, {
                elementName: 'zIndexByJs',
                typeInfo: '.If.ZIndexByJs'
              }, {
                elementName: 'backgroundRepeatByJs',
                typeInfo: '.If.BackgroundRepeatByJs'
              }, {
                elementName: 'table',
                typeInfo: '.Table'
              }, {
                elementName: 'thead',
                typeInfo: '.Thead'
              }, {
                elementName: 'tr',
                typeInfo: '.Tr'
              }, {
                elementName: 'tbody',
                typeInfo: '.Tbody'
              }, {
                elementName: 'tloop',
                typeInfo: '.Tloop'
              }, {
                elementName: 'tbottom',
                typeInfo: '.Tbottom'
              }, {
                elementName: 'th',
                typeInfo: '.Th'
              }, {
                elementName: 'td',
                typeInfo: '.Td'
              }, {
                elementName: 'div',
                typeInfo: '.Div'
              }, {
                elementName: 'span',
                typeInfo: '.Span'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }],
            type: 'elements'
          }, {
            name: 'itemsJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'itemsJs'
            },
            type: 'attribute'
          }, {
            name: 'var',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'var'
            },
            type: 'attribute'
          }, {
            name: 'varStatus',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'varStatus'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BackgroundColor',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BackgroundSize',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Div',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'table',
                typeInfo: '.Table'
              }, {
                elementName: 'div',
                typeInfo: '.Div'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'span',
                typeInfo: '.Span'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'scaleToFitContentByPdf',
            attributeName: {
              localPart: 'scaleToFitContentByPdf'
            },
            type: 'attribute'
          }, {
            name: 'explain',
            attributeName: {
              localPart: 'explain'
            },
            type: 'attribute'
          }, {
            name: 'cls',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cls'
            },
            type: 'attribute'
          }, {
            name: 'width',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'width'
            },
            type: 'attribute'
          }, {
            name: 'height',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'height'
            },
            type: 'attribute'
          }, {
            name: 'paddingLeft',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingLeft'
            },
            type: 'attribute'
          }, {
            name: 'paddingTop',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingTop'
            },
            type: 'attribute'
          }, {
            name: 'paddingRight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingRight'
            },
            type: 'attribute'
          }, {
            name: 'paddingBottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingBottom'
            },
            type: 'attribute'
          }, {
            name: 'marginLeftByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginLeftByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginTopByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginTopByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginRightByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginRightByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginBottomByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginBottomByJs'
            },
            type: 'attribute'
          }, {
            name: 'fontFamily',
            attributeName: {
              localPart: 'fontFamily'
            },
            type: 'attribute'
          }, {
            name: 'fontStyle',
            attributeName: {
              localPart: 'fontStyle'
            },
            type: 'attribute'
          }, {
            name: 'fontWeight',
            attributeName: {
              localPart: 'fontWeight'
            },
            type: 'attribute'
          }, {
            name: 'textDecoration',
            attributeName: {
              localPart: 'textDecoration'
            },
            type: 'attribute'
          }, {
            name: 'borderCollapse',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderCollapse'
            },
            type: 'attribute'
          }, {
            name: 'borderSpacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderSpacing'
            },
            type: 'attribute'
          }, {
            name: 'tableLayout',
            attributeName: {
              localPart: 'tableLayout'
            },
            type: 'attribute'
          }, {
            name: 'textAlign',
            attributeName: {
              localPart: 'textAlign'
            },
            type: 'attribute'
          }, {
            name: 'whiteSpace',
            attributeName: {
              localPart: 'whiteSpace'
            },
            type: 'attribute'
          }, {
            name: 'wordWrap',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'wordWrap'
            },
            type: 'attribute'
          }, {
            name: 'display',
            attributeName: {
              localPart: 'display'
            },
            type: 'attribute'
          }, {
            name: 'visibility',
            attributeName: {
              localPart: 'visibility'
            },
            type: 'attribute'
          }, {
            name: 'clear',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'clear'
            },
            type: 'attribute'
          }, {
            name: 'zoom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zoom'
            },
            type: 'attribute'
          }, {
            name: 'floatAlign',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'floatAlign'
            },
            type: 'attribute'
          }, {
            name: 'fontSize',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'fontSize'
            },
            type: 'attribute'
          }, {
            name: 'webkitBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'webkitBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'mozBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'mozBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'boxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'boxSizing'
            },
            type: 'attribute'
          }, {
            name: 'minHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'minHeight'
            },
            type: 'attribute'
          }, {
            name: 'position',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'position'
            },
            type: 'attribute'
          }, {
            name: 'lineHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'lineHeight'
            },
            type: 'attribute'
          }, {
            name: 'color',
            attributeName: {
              localPart: 'color'
            },
            type: 'attribute'
          }, {
            name: 'borderTopWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderTopWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderTopStyle',
            attributeName: {
              localPart: 'borderTopStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderTopColor',
            attributeName: {
              localPart: 'borderTopColor'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderLeftWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftStyle',
            attributeName: {
              localPart: 'borderLeftStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftColor',
            attributeName: {
              localPart: 'borderLeftColor'
            },
            type: 'attribute'
          }, {
            name: 'borderRightWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderRightWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderRightStyle',
            attributeName: {
              localPart: 'borderRightStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderRightColor',
            attributeName: {
              localPart: 'borderRightColor'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderBottomWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomStyle',
            attributeName: {
              localPart: 'borderBottomStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomColor',
            attributeName: {
              localPart: 'borderBottomColor'
            },
            type: 'attribute'
          }, {
            name: 'maxWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxWidth'
            },
            type: 'attribute'
          }, {
            name: 'left',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'left'
            },
            type: 'attribute'
          }, {
            name: 'top',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'top'
            },
            type: 'attribute'
          }, {
            name: 'right',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'right'
            },
            type: 'attribute'
          }, {
            name: 'bottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'bottom'
            },
            type: 'attribute'
          }, {
            name: 'verticalAlign',
            attributeName: {
              localPart: 'verticalAlign'
            },
            type: 'attribute'
          }, {
            name: 'overflowX',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowX'
            },
            type: 'attribute'
          }, {
            name: 'overflowY',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowY'
            },
            type: 'attribute'
          }, {
            name: 'maxHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxHeight'
            },
            type: 'attribute'
          }, {
            name: 'backgroundColor',
            attributeName: {
              localPart: 'backgroundColor'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImage',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImage'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImageOpacityByPdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImageOpacityByPdf'
            },
            type: 'attribute'
          }, {
            name: 'backgroundSize',
            attributeName: {
              localPart: 'backgroundSize'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionX',
            attributeName: {
              localPart: 'backgroundPositionX'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionY',
            attributeName: {
              localPart: 'backgroundPositionY'
            },
            type: 'attribute'
          }, {
            name: 'transformByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'transformByJs'
            },
            type: 'attribute'
          }, {
            name: 'opacityByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'opacityByJs'
            },
            type: 'attribute'
          }, {
            name: 'zIndexByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zIndexByJs'
            },
            type: 'attribute'
          }, {
            name: 'backgroundRepeatByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundRepeatByJs'
            },
            type: 'attribute'
          }, {
            name: 'cellspacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellspacing'
            },
            type: 'attribute'
          }, {
            name: 'cellpadding',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellpadding'
            },
            type: 'attribute'
          }, {
            name: 'colspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'colspan'
            },
            type: 'attribute'
          }, {
            name: 'rowspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'rowspan'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Tbody',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'tr',
                typeInfo: '.Tr'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.FontFamily',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Param',
        typeName: null,
        propertyInfos: [{
            name: 'name',
            attributeName: {
              localPart: 'name'
            },
            type: 'attribute'
          }, {
            name: 'value',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'value'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Tr',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'td',
                typeInfo: '.Td'
              }, {
                elementName: 'th',
                typeInfo: '.Th'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'cls',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cls'
            },
            type: 'attribute'
          }, {
            name: 'width',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'width'
            },
            type: 'attribute'
          }, {
            name: 'height',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'height'
            },
            type: 'attribute'
          }, {
            name: 'paddingLeft',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingLeft'
            },
            type: 'attribute'
          }, {
            name: 'paddingTop',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingTop'
            },
            type: 'attribute'
          }, {
            name: 'paddingRight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingRight'
            },
            type: 'attribute'
          }, {
            name: 'paddingBottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingBottom'
            },
            type: 'attribute'
          }, {
            name: 'marginLeftByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginLeftByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginTopByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginTopByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginRightByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginRightByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginBottomByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginBottomByJs'
            },
            type: 'attribute'
          }, {
            name: 'fontFamily',
            attributeName: {
              localPart: 'fontFamily'
            },
            type: 'attribute'
          }, {
            name: 'fontStyle',
            attributeName: {
              localPart: 'fontStyle'
            },
            type: 'attribute'
          }, {
            name: 'fontWeight',
            attributeName: {
              localPart: 'fontWeight'
            },
            type: 'attribute'
          }, {
            name: 'textDecoration',
            attributeName: {
              localPart: 'textDecoration'
            },
            type: 'attribute'
          }, {
            name: 'borderCollapse',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderCollapse'
            },
            type: 'attribute'
          }, {
            name: 'borderSpacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderSpacing'
            },
            type: 'attribute'
          }, {
            name: 'tableLayout',
            attributeName: {
              localPart: 'tableLayout'
            },
            type: 'attribute'
          }, {
            name: 'textAlign',
            attributeName: {
              localPart: 'textAlign'
            },
            type: 'attribute'
          }, {
            name: 'whiteSpace',
            attributeName: {
              localPart: 'whiteSpace'
            },
            type: 'attribute'
          }, {
            name: 'wordWrap',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'wordWrap'
            },
            type: 'attribute'
          }, {
            name: 'display',
            attributeName: {
              localPart: 'display'
            },
            type: 'attribute'
          }, {
            name: 'visibility',
            attributeName: {
              localPart: 'visibility'
            },
            type: 'attribute'
          }, {
            name: 'clear',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'clear'
            },
            type: 'attribute'
          }, {
            name: 'zoom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zoom'
            },
            type: 'attribute'
          }, {
            name: 'floatAlign',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'floatAlign'
            },
            type: 'attribute'
          }, {
            name: 'fontSize',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'fontSize'
            },
            type: 'attribute'
          }, {
            name: 'webkitBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'webkitBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'mozBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'mozBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'boxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'boxSizing'
            },
            type: 'attribute'
          }, {
            name: 'minHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'minHeight'
            },
            type: 'attribute'
          }, {
            name: 'position',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'position'
            },
            type: 'attribute'
          }, {
            name: 'lineHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'lineHeight'
            },
            type: 'attribute'
          }, {
            name: 'color',
            attributeName: {
              localPart: 'color'
            },
            type: 'attribute'
          }, {
            name: 'borderTopWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderTopWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderTopStyle',
            attributeName: {
              localPart: 'borderTopStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderTopColor',
            attributeName: {
              localPart: 'borderTopColor'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderLeftWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftStyle',
            attributeName: {
              localPart: 'borderLeftStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftColor',
            attributeName: {
              localPart: 'borderLeftColor'
            },
            type: 'attribute'
          }, {
            name: 'borderRightWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderRightWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderRightStyle',
            attributeName: {
              localPart: 'borderRightStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderRightColor',
            attributeName: {
              localPart: 'borderRightColor'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderBottomWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomStyle',
            attributeName: {
              localPart: 'borderBottomStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomColor',
            attributeName: {
              localPart: 'borderBottomColor'
            },
            type: 'attribute'
          }, {
            name: 'maxWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxWidth'
            },
            type: 'attribute'
          }, {
            name: 'left',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'left'
            },
            type: 'attribute'
          }, {
            name: 'top',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'top'
            },
            type: 'attribute'
          }, {
            name: 'right',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'right'
            },
            type: 'attribute'
          }, {
            name: 'bottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'bottom'
            },
            type: 'attribute'
          }, {
            name: 'verticalAlign',
            attributeName: {
              localPart: 'verticalAlign'
            },
            type: 'attribute'
          }, {
            name: 'overflowX',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowX'
            },
            type: 'attribute'
          }, {
            name: 'overflowY',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowY'
            },
            type: 'attribute'
          }, {
            name: 'maxHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxHeight'
            },
            type: 'attribute'
          }, {
            name: 'backgroundColor',
            attributeName: {
              localPart: 'backgroundColor'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImage',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImage'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImageOpacityByPdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImageOpacityByPdf'
            },
            type: 'attribute'
          }, {
            name: 'backgroundSize',
            attributeName: {
              localPart: 'backgroundSize'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionX',
            attributeName: {
              localPart: 'backgroundPositionX'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionY',
            attributeName: {
              localPart: 'backgroundPositionY'
            },
            type: 'attribute'
          }, {
            name: 'transformByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'transformByJs'
            },
            type: 'attribute'
          }, {
            name: 'opacityByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'opacityByJs'
            },
            type: 'attribute'
          }, {
            name: 'zIndexByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zIndexByJs'
            },
            type: 'attribute'
          }, {
            name: 'backgroundRepeatByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundRepeatByJs'
            },
            type: 'attribute'
          }, {
            name: 'cellspacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellspacing'
            },
            type: 'attribute'
          }, {
            name: 'cellpadding',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellpadding'
            },
            type: 'attribute'
          }, {
            name: 'colspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'colspan'
            },
            type: 'attribute'
          }, {
            name: 'rowspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'rowspan'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.MarginTopByJs',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.WordWrap',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.MaxHeight',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Style',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }],
            type: 'elements'
          }]
      }, {
        localName: 'If.OverflowY',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Css',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'width',
                typeInfo: '.If.Width'
              }, {
                elementName: 'height',
                typeInfo: '.If.Height'
              }, {
                elementName: 'paddingLeft',
                typeInfo: '.If.PaddingLeft'
              }, {
                elementName: 'paddingTop',
                typeInfo: '.If.PaddingTop'
              }, {
                elementName: 'paddingRight',
                typeInfo: '.If.PaddingRight'
              }, {
                elementName: 'paddingBottom',
                typeInfo: '.If.PaddingBottom'
              }, {
                elementName: 'marginLeftByJs',
                typeInfo: '.If.MarginLeftByJs'
              }, {
                elementName: 'marginTopByJs',
                typeInfo: '.If.MarginTopByJs'
              }, {
                elementName: 'marginRightByJs',
                typeInfo: '.If.MarginRightByJs'
              }, {
                elementName: 'marginBottomByJs',
                typeInfo: '.If.MarginBottomByJs'
              }, {
                elementName: 'fontFamily',
                typeInfo: '.If.FontFamily'
              }, {
                elementName: 'fontStyle',
                typeInfo: '.If.FontStyle'
              }, {
                elementName: 'fontWeight',
                typeInfo: '.If.FontWeight'
              }, {
                elementName: 'textDecoration',
                typeInfo: '.If.TextDecoration'
              }, {
                elementName: 'borderCollapse',
                typeInfo: '.If.BorderCollapse'
              }, {
                elementName: 'borderSpacing',
                typeInfo: '.If.BorderSpacing'
              }, {
                elementName: 'tableLayout',
                typeInfo: '.If.TableLayout'
              }, {
                elementName: 'textAlign',
                typeInfo: '.If.TextAlign'
              }, {
                elementName: 'whiteSpace',
                typeInfo: '.If.WhiteSpace'
              }, {
                elementName: 'wordWrap',
                typeInfo: '.If.WordWrap'
              }, {
                elementName: 'display',
                typeInfo: '.If.Display'
              }, {
                elementName: 'visibility',
                typeInfo: '.If.Visibility'
              }, {
                elementName: 'clear',
                typeInfo: '.If.Clear'
              }, {
                elementName: 'zoom',
                typeInfo: '.If.Zoom'
              }, {
                elementName: 'floatAlign',
                typeInfo: '.If.FloatAlign'
              }, {
                elementName: 'fontSize',
                typeInfo: '.If.FontSize'
              }, {
                elementName: 'webkitBoxSizing',
                typeInfo: '.If.WebkitBoxSizing'
              }, {
                elementName: 'mozBoxSizing',
                typeInfo: '.If.MozBoxSizing'
              }, {
                elementName: 'boxSizing',
                typeInfo: '.If.BoxSizing'
              }, {
                elementName: 'minHeight',
                typeInfo: '.If.MinHeight'
              }, {
                elementName: 'position',
                typeInfo: '.If.Position'
              }, {
                elementName: 'lineHeight',
                typeInfo: '.If.LineHeight'
              }, {
                elementName: 'color',
                typeInfo: '.If.Color'
              }, {
                elementName: 'borderTopWidth',
                typeInfo: '.If.BorderTopWidth'
              }, {
                elementName: 'borderTopStyle',
                typeInfo: '.If.BorderTopStyle'
              }, {
                elementName: 'borderTopColor',
                typeInfo: '.If.BorderTopColor'
              }, {
                elementName: 'borderLeftWidth',
                typeInfo: '.If.BorderLeftWidth'
              }, {
                elementName: 'borderLeftStyle',
                typeInfo: '.If.BorderLeftStyle'
              }, {
                elementName: 'borderLeftColor',
                typeInfo: '.If.BorderLeftColor'
              }, {
                elementName: 'borderRightWidth',
                typeInfo: '.If.BorderRightWidth'
              }, {
                elementName: 'borderRightStyle',
                typeInfo: '.If.BorderRightStyle'
              }, {
                elementName: 'borderRightColor',
                typeInfo: '.If.BorderRightColor'
              }, {
                elementName: 'borderBottomWidth',
                typeInfo: '.If.BorderBottomWidth'
              }, {
                elementName: 'borderBottomStyle',
                typeInfo: '.If.BorderBottomStyle'
              }, {
                elementName: 'borderBottomColor',
                typeInfo: '.If.BorderBottomColor'
              }, {
                elementName: 'maxWidth',
                typeInfo: '.If.MaxWidth'
              }, {
                elementName: 'left',
                typeInfo: '.If.Left'
              }, {
                elementName: 'top',
                typeInfo: '.If.Top'
              }, {
                elementName: 'right',
                typeInfo: '.If.Right'
              }, {
                elementName: 'bottom',
                typeInfo: '.If.Bottom'
              }, {
                elementName: 'verticalAlign',
                typeInfo: '.If.VerticalAlign'
              }, {
                elementName: 'overflowX',
                typeInfo: '.If.OverflowX'
              }, {
                elementName: 'overflowY',
                typeInfo: '.If.OverflowY'
              }, {
                elementName: 'maxHeight',
                typeInfo: '.If.MaxHeight'
              }, {
                elementName: 'backgroundColor',
                typeInfo: '.If.BackgroundColor'
              }, {
                elementName: 'backgroundImage',
                typeInfo: '.If.BackgroundImage'
              }, {
                elementName: 'backgroundImageOpacityByPdf',
                typeInfo: '.If.BackgroundImageOpacityByPdf'
              }, {
                elementName: 'backgroundSize',
                typeInfo: '.If.BackgroundSize'
              }, {
                elementName: 'backgroundPositionX',
                typeInfo: '.If.BackgroundPositionX'
              }, {
                elementName: 'backgroundPositionY',
                typeInfo: '.If.BackgroundPositionY'
              }, {
                elementName: 'transformByJs',
                typeInfo: '.If.TransformByJs'
              }, {
                elementName: 'opacityByJs',
                typeInfo: '.If.OpacityByJs'
              }, {
                elementName: 'zIndexByJs',
                typeInfo: '.If.ZIndexByJs'
              }, {
                elementName: 'backgroundRepeatByJs',
                typeInfo: '.If.BackgroundRepeatByJs'
              }],
            type: 'elements'
          }, {
            name: 'name',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'name'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Macros',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'macro',
                typeInfo: '.Macro'
              }],
            type: 'elements'
          }]
      }, {
        localName: 'If.PaddingLeft',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Params',
        typeName: null,
        propertyInfos: [{
            name: 'param',
            minOccurs: 0,
            collection: true,
            typeInfo: '.Param'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderCollapse',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderTopColor',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Bottom',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BackgroundRepeatByJs',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Zoom',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Span',
        typeName: null,
        propertyInfos: [{
            name: 'cssAndParams',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'value',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'value'
            },
            type: 'attribute'
          }, {
            name: 'explain',
            attributeName: {
              localPart: 'explain'
            },
            type: 'attribute'
          }, {
            name: 'format',
            attributeName: {
              localPart: 'format'
            },
            type: 'attribute'
          }, {
            name: 'cls',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cls'
            },
            type: 'attribute'
          }, {
            name: 'width',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'width'
            },
            type: 'attribute'
          }, {
            name: 'height',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'height'
            },
            type: 'attribute'
          }, {
            name: 'paddingLeft',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingLeft'
            },
            type: 'attribute'
          }, {
            name: 'paddingTop',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingTop'
            },
            type: 'attribute'
          }, {
            name: 'paddingRight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingRight'
            },
            type: 'attribute'
          }, {
            name: 'paddingBottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingBottom'
            },
            type: 'attribute'
          }, {
            name: 'marginLeftByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginLeftByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginTopByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginTopByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginRightByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginRightByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginBottomByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginBottomByJs'
            },
            type: 'attribute'
          }, {
            name: 'fontFamily',
            attributeName: {
              localPart: 'fontFamily'
            },
            type: 'attribute'
          }, {
            name: 'fontStyle',
            attributeName: {
              localPart: 'fontStyle'
            },
            type: 'attribute'
          }, {
            name: 'fontWeight',
            attributeName: {
              localPart: 'fontWeight'
            },
            type: 'attribute'
          }, {
            name: 'textDecoration',
            attributeName: {
              localPart: 'textDecoration'
            },
            type: 'attribute'
          }, {
            name: 'borderCollapse',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderCollapse'
            },
            type: 'attribute'
          }, {
            name: 'borderSpacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderSpacing'
            },
            type: 'attribute'
          }, {
            name: 'tableLayout',
            attributeName: {
              localPart: 'tableLayout'
            },
            type: 'attribute'
          }, {
            name: 'textAlign',
            attributeName: {
              localPart: 'textAlign'
            },
            type: 'attribute'
          }, {
            name: 'whiteSpace',
            attributeName: {
              localPart: 'whiteSpace'
            },
            type: 'attribute'
          }, {
            name: 'wordWrap',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'wordWrap'
            },
            type: 'attribute'
          }, {
            name: 'display',
            attributeName: {
              localPart: 'display'
            },
            type: 'attribute'
          }, {
            name: 'visibility',
            attributeName: {
              localPart: 'visibility'
            },
            type: 'attribute'
          }, {
            name: 'clear',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'clear'
            },
            type: 'attribute'
          }, {
            name: 'zoom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zoom'
            },
            type: 'attribute'
          }, {
            name: 'floatAlign',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'floatAlign'
            },
            type: 'attribute'
          }, {
            name: 'fontSize',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'fontSize'
            },
            type: 'attribute'
          }, {
            name: 'webkitBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'webkitBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'mozBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'mozBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'boxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'boxSizing'
            },
            type: 'attribute'
          }, {
            name: 'minHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'minHeight'
            },
            type: 'attribute'
          }, {
            name: 'position',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'position'
            },
            type: 'attribute'
          }, {
            name: 'lineHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'lineHeight'
            },
            type: 'attribute'
          }, {
            name: 'color',
            attributeName: {
              localPart: 'color'
            },
            type: 'attribute'
          }, {
            name: 'borderTopWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderTopWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderTopStyle',
            attributeName: {
              localPart: 'borderTopStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderTopColor',
            attributeName: {
              localPart: 'borderTopColor'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderLeftWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftStyle',
            attributeName: {
              localPart: 'borderLeftStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftColor',
            attributeName: {
              localPart: 'borderLeftColor'
            },
            type: 'attribute'
          }, {
            name: 'borderRightWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderRightWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderRightStyle',
            attributeName: {
              localPart: 'borderRightStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderRightColor',
            attributeName: {
              localPart: 'borderRightColor'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderBottomWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomStyle',
            attributeName: {
              localPart: 'borderBottomStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomColor',
            attributeName: {
              localPart: 'borderBottomColor'
            },
            type: 'attribute'
          }, {
            name: 'maxWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxWidth'
            },
            type: 'attribute'
          }, {
            name: 'left',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'left'
            },
            type: 'attribute'
          }, {
            name: 'top',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'top'
            },
            type: 'attribute'
          }, {
            name: 'right',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'right'
            },
            type: 'attribute'
          }, {
            name: 'bottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'bottom'
            },
            type: 'attribute'
          }, {
            name: 'verticalAlign',
            attributeName: {
              localPart: 'verticalAlign'
            },
            type: 'attribute'
          }, {
            name: 'overflowX',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowX'
            },
            type: 'attribute'
          }, {
            name: 'overflowY',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowY'
            },
            type: 'attribute'
          }, {
            name: 'maxHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxHeight'
            },
            type: 'attribute'
          }, {
            name: 'backgroundColor',
            attributeName: {
              localPart: 'backgroundColor'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImage',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImage'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImageOpacityByPdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImageOpacityByPdf'
            },
            type: 'attribute'
          }, {
            name: 'backgroundSize',
            attributeName: {
              localPart: 'backgroundSize'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionX',
            attributeName: {
              localPart: 'backgroundPositionX'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionY',
            attributeName: {
              localPart: 'backgroundPositionY'
            },
            type: 'attribute'
          }, {
            name: 'transformByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'transformByJs'
            },
            type: 'attribute'
          }, {
            name: 'opacityByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'opacityByJs'
            },
            type: 'attribute'
          }, {
            name: 'zIndexByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zIndexByJs'
            },
            type: 'attribute'
          }, {
            name: 'backgroundRepeatByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundRepeatByJs'
            },
            type: 'attribute'
          }, {
            name: 'cellspacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellspacing'
            },
            type: 'attribute'
          }, {
            name: 'cellpadding',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellpadding'
            },
            type: 'attribute'
          }, {
            name: 'colspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'colspan'
            },
            type: 'attribute'
          }, {
            name: 'rowspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'rowspan'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.TextDecoration',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.Height',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'MacroRef',
        typeName: null,
        propertyInfos: [{
            name: 'widthAndHeightAndPaddingLeft',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'width',
                typeInfo: '.If.Width'
              }, {
                elementName: 'height',
                typeInfo: '.If.Height'
              }, {
                elementName: 'paddingLeft',
                typeInfo: '.If.PaddingLeft'
              }, {
                elementName: 'paddingTop',
                typeInfo: '.If.PaddingTop'
              }, {
                elementName: 'paddingRight',
                typeInfo: '.If.PaddingRight'
              }, {
                elementName: 'paddingBottom',
                typeInfo: '.If.PaddingBottom'
              }, {
                elementName: 'marginLeftByJs',
                typeInfo: '.If.MarginLeftByJs'
              }, {
                elementName: 'marginTopByJs',
                typeInfo: '.If.MarginTopByJs'
              }, {
                elementName: 'marginRightByJs',
                typeInfo: '.If.MarginRightByJs'
              }, {
                elementName: 'marginBottomByJs',
                typeInfo: '.If.MarginBottomByJs'
              }, {
                elementName: 'fontFamily',
                typeInfo: '.If.FontFamily'
              }, {
                elementName: 'fontStyle',
                typeInfo: '.If.FontStyle'
              }, {
                elementName: 'fontWeight',
                typeInfo: '.If.FontWeight'
              }, {
                elementName: 'textDecoration',
                typeInfo: '.If.TextDecoration'
              }, {
                elementName: 'borderCollapse',
                typeInfo: '.If.BorderCollapse'
              }, {
                elementName: 'borderSpacing',
                typeInfo: '.If.BorderSpacing'
              }, {
                elementName: 'tableLayout',
                typeInfo: '.If.TableLayout'
              }, {
                elementName: 'textAlign',
                typeInfo: '.If.TextAlign'
              }, {
                elementName: 'whiteSpace',
                typeInfo: '.If.WhiteSpace'
              }, {
                elementName: 'wordWrap',
                typeInfo: '.If.WordWrap'
              }, {
                elementName: 'display',
                typeInfo: '.If.Display'
              }, {
                elementName: 'visibility',
                typeInfo: '.If.Visibility'
              }, {
                elementName: 'clear',
                typeInfo: '.If.Clear'
              }, {
                elementName: 'zoom',
                typeInfo: '.If.Zoom'
              }, {
                elementName: 'floatAlign',
                typeInfo: '.If.FloatAlign'
              }, {
                elementName: 'fontSize',
                typeInfo: '.If.FontSize'
              }, {
                elementName: 'webkitBoxSizing',
                typeInfo: '.If.WebkitBoxSizing'
              }, {
                elementName: 'mozBoxSizing',
                typeInfo: '.If.MozBoxSizing'
              }, {
                elementName: 'boxSizing',
                typeInfo: '.If.BoxSizing'
              }, {
                elementName: 'minHeight',
                typeInfo: '.If.MinHeight'
              }, {
                elementName: 'position',
                typeInfo: '.If.Position'
              }, {
                elementName: 'lineHeight',
                typeInfo: '.If.LineHeight'
              }, {
                elementName: 'color',
                typeInfo: '.If.Color'
              }, {
                elementName: 'borderTopWidth',
                typeInfo: '.If.BorderTopWidth'
              }, {
                elementName: 'borderTopStyle',
                typeInfo: '.If.BorderTopStyle'
              }, {
                elementName: 'borderTopColor',
                typeInfo: '.If.BorderTopColor'
              }, {
                elementName: 'borderLeftWidth',
                typeInfo: '.If.BorderLeftWidth'
              }, {
                elementName: 'borderLeftStyle',
                typeInfo: '.If.BorderLeftStyle'
              }, {
                elementName: 'borderLeftColor',
                typeInfo: '.If.BorderLeftColor'
              }, {
                elementName: 'borderRightWidth',
                typeInfo: '.If.BorderRightWidth'
              }, {
                elementName: 'borderRightStyle',
                typeInfo: '.If.BorderRightStyle'
              }, {
                elementName: 'borderRightColor',
                typeInfo: '.If.BorderRightColor'
              }, {
                elementName: 'borderBottomWidth',
                typeInfo: '.If.BorderBottomWidth'
              }, {
                elementName: 'borderBottomStyle',
                typeInfo: '.If.BorderBottomStyle'
              }, {
                elementName: 'borderBottomColor',
                typeInfo: '.If.BorderBottomColor'
              }, {
                elementName: 'maxWidth',
                typeInfo: '.If.MaxWidth'
              }, {
                elementName: 'left',
                typeInfo: '.If.Left'
              }, {
                elementName: 'top',
                typeInfo: '.If.Top'
              }, {
                elementName: 'right',
                typeInfo: '.If.Right'
              }, {
                elementName: 'bottom',
                typeInfo: '.If.Bottom'
              }, {
                elementName: 'verticalAlign',
                typeInfo: '.If.VerticalAlign'
              }, {
                elementName: 'overflowX',
                typeInfo: '.If.OverflowX'
              }, {
                elementName: 'overflowY',
                typeInfo: '.If.OverflowY'
              }, {
                elementName: 'maxHeight',
                typeInfo: '.If.MaxHeight'
              }, {
                elementName: 'backgroundColor',
                typeInfo: '.If.BackgroundColor'
              }, {
                elementName: 'backgroundImage',
                typeInfo: '.If.BackgroundImage'
              }, {
                elementName: 'backgroundImageOpacityByPdf',
                typeInfo: '.If.BackgroundImageOpacityByPdf'
              }, {
                elementName: 'backgroundSize',
                typeInfo: '.If.BackgroundSize'
              }, {
                elementName: 'backgroundPositionX',
                typeInfo: '.If.BackgroundPositionX'
              }, {
                elementName: 'backgroundPositionY',
                typeInfo: '.If.BackgroundPositionY'
              }, {
                elementName: 'transformByJs',
                typeInfo: '.If.TransformByJs'
              }, {
                elementName: 'opacityByJs',
                typeInfo: '.If.OpacityByJs'
              }, {
                elementName: 'zIndexByJs',
                typeInfo: '.If.ZIndexByJs'
              }, {
                elementName: 'backgroundRepeatByJs',
                typeInfo: '.If.BackgroundRepeatByJs'
              }, {
                elementName: 'table',
                typeInfo: '.Table'
              }, {
                elementName: 'thead',
                typeInfo: '.Thead'
              }, {
                elementName: 'tr',
                typeInfo: '.Tr'
              }, {
                elementName: 'tbody',
                typeInfo: '.Tbody'
              }, {
                elementName: 'tloop',
                typeInfo: '.Tloop'
              }, {
                elementName: 'tbottom',
                typeInfo: '.Tbottom'
              }, {
                elementName: 'th',
                typeInfo: '.Th'
              }, {
                elementName: 'td',
                typeInfo: '.Td'
              }, {
                elementName: 'div',
                typeInfo: '.Div'
              }, {
                elementName: 'span',
                typeInfo: '.Span'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }],
            type: 'elements'
          }, {
            name: 'name',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'name'
            },
            type: 'attribute'
          }, {
            name: 'paramJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paramJs'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.LineHeight',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.OpacityByJs',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If',
        typeName: null,
        propertyInfos: [{
            name: 'widthAndHeightAndPaddingLeft',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'width',
                typeInfo: '.If.Width'
              }, {
                elementName: 'height',
                typeInfo: '.If.Height'
              }, {
                elementName: 'paddingLeft',
                typeInfo: '.If.PaddingLeft'
              }, {
                elementName: 'paddingTop',
                typeInfo: '.If.PaddingTop'
              }, {
                elementName: 'paddingRight',
                typeInfo: '.If.PaddingRight'
              }, {
                elementName: 'paddingBottom',
                typeInfo: '.If.PaddingBottom'
              }, {
                elementName: 'marginLeftByJs',
                typeInfo: '.If.MarginLeftByJs'
              }, {
                elementName: 'marginTopByJs',
                typeInfo: '.If.MarginTopByJs'
              }, {
                elementName: 'marginRightByJs',
                typeInfo: '.If.MarginRightByJs'
              }, {
                elementName: 'marginBottomByJs',
                typeInfo: '.If.MarginBottomByJs'
              }, {
                elementName: 'fontFamily',
                typeInfo: '.If.FontFamily'
              }, {
                elementName: 'fontStyle',
                typeInfo: '.If.FontStyle'
              }, {
                elementName: 'fontWeight',
                typeInfo: '.If.FontWeight'
              }, {
                elementName: 'textDecoration',
                typeInfo: '.If.TextDecoration'
              }, {
                elementName: 'borderCollapse',
                typeInfo: '.If.BorderCollapse'
              }, {
                elementName: 'borderSpacing',
                typeInfo: '.If.BorderSpacing'
              }, {
                elementName: 'tableLayout',
                typeInfo: '.If.TableLayout'
              }, {
                elementName: 'textAlign',
                typeInfo: '.If.TextAlign'
              }, {
                elementName: 'whiteSpace',
                typeInfo: '.If.WhiteSpace'
              }, {
                elementName: 'wordWrap',
                typeInfo: '.If.WordWrap'
              }, {
                elementName: 'display',
                typeInfo: '.If.Display'
              }, {
                elementName: 'visibility',
                typeInfo: '.If.Visibility'
              }, {
                elementName: 'clear',
                typeInfo: '.If.Clear'
              }, {
                elementName: 'zoom',
                typeInfo: '.If.Zoom'
              }, {
                elementName: 'floatAlign',
                typeInfo: '.If.FloatAlign'
              }, {
                elementName: 'fontSize',
                typeInfo: '.If.FontSize'
              }, {
                elementName: 'webkitBoxSizing',
                typeInfo: '.If.WebkitBoxSizing'
              }, {
                elementName: 'mozBoxSizing',
                typeInfo: '.If.MozBoxSizing'
              }, {
                elementName: 'boxSizing',
                typeInfo: '.If.BoxSizing'
              }, {
                elementName: 'minHeight',
                typeInfo: '.If.MinHeight'
              }, {
                elementName: 'position',
                typeInfo: '.If.Position'
              }, {
                elementName: 'lineHeight',
                typeInfo: '.If.LineHeight'
              }, {
                elementName: 'color',
                typeInfo: '.If.Color'
              }, {
                elementName: 'borderTopWidth',
                typeInfo: '.If.BorderTopWidth'
              }, {
                elementName: 'borderTopStyle',
                typeInfo: '.If.BorderTopStyle'
              }, {
                elementName: 'borderTopColor',
                typeInfo: '.If.BorderTopColor'
              }, {
                elementName: 'borderLeftWidth',
                typeInfo: '.If.BorderLeftWidth'
              }, {
                elementName: 'borderLeftStyle',
                typeInfo: '.If.BorderLeftStyle'
              }, {
                elementName: 'borderLeftColor',
                typeInfo: '.If.BorderLeftColor'
              }, {
                elementName: 'borderRightWidth',
                typeInfo: '.If.BorderRightWidth'
              }, {
                elementName: 'borderRightStyle',
                typeInfo: '.If.BorderRightStyle'
              }, {
                elementName: 'borderRightColor',
                typeInfo: '.If.BorderRightColor'
              }, {
                elementName: 'borderBottomWidth',
                typeInfo: '.If.BorderBottomWidth'
              }, {
                elementName: 'borderBottomStyle',
                typeInfo: '.If.BorderBottomStyle'
              }, {
                elementName: 'borderBottomColor',
                typeInfo: '.If.BorderBottomColor'
              }, {
                elementName: 'maxWidth',
                typeInfo: '.If.MaxWidth'
              }, {
                elementName: 'left',
                typeInfo: '.If.Left'
              }, {
                elementName: 'top',
                typeInfo: '.If.Top'
              }, {
                elementName: 'right',
                typeInfo: '.If.Right'
              }, {
                elementName: 'bottom',
                typeInfo: '.If.Bottom'
              }, {
                elementName: 'verticalAlign',
                typeInfo: '.If.VerticalAlign'
              }, {
                elementName: 'overflowX',
                typeInfo: '.If.OverflowX'
              }, {
                elementName: 'overflowY',
                typeInfo: '.If.OverflowY'
              }, {
                elementName: 'maxHeight',
                typeInfo: '.If.MaxHeight'
              }, {
                elementName: 'backgroundColor',
                typeInfo: '.If.BackgroundColor'
              }, {
                elementName: 'backgroundImage',
                typeInfo: '.If.BackgroundImage'
              }, {
                elementName: 'backgroundImageOpacityByPdf',
                typeInfo: '.If.BackgroundImageOpacityByPdf'
              }, {
                elementName: 'backgroundSize',
                typeInfo: '.If.BackgroundSize'
              }, {
                elementName: 'backgroundPositionX',
                typeInfo: '.If.BackgroundPositionX'
              }, {
                elementName: 'backgroundPositionY',
                typeInfo: '.If.BackgroundPositionY'
              }, {
                elementName: 'transformByJs',
                typeInfo: '.If.TransformByJs'
              }, {
                elementName: 'opacityByJs',
                typeInfo: '.If.OpacityByJs'
              }, {
                elementName: 'zIndexByJs',
                typeInfo: '.If.ZIndexByJs'
              }, {
                elementName: 'backgroundRepeatByJs',
                typeInfo: '.If.BackgroundRepeatByJs'
              }, {
                elementName: 'table',
                typeInfo: '.Table'
              }, {
                elementName: 'thead',
                typeInfo: '.Thead'
              }, {
                elementName: 'tr',
                typeInfo: '.Tr'
              }, {
                elementName: 'tbody',
                typeInfo: '.Tbody'
              }, {
                elementName: 'tloop',
                typeInfo: '.Tloop'
              }, {
                elementName: 'tbottom',
                typeInfo: '.Tbottom'
              }, {
                elementName: 'th',
                typeInfo: '.Th'
              }, {
                elementName: 'td',
                typeInfo: '.Td'
              }, {
                elementName: 'div',
                typeInfo: '.Div'
              }, {
                elementName: 'span',
                typeInfo: '.Span'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }],
            type: 'elements'
          }, {
            name: 'testJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'testJs'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Html',
        typeName: null,
        propertyInfos: [{
            name: 'style',
            typeInfo: '.Style'
          }, {
            name: 'macros',
            typeInfo: '.Macros'
          }, {
            name: 'body',
            typeInfo: '.Body'
          }]
      }, {
        localName: 'If.BorderRightStyle',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.TextAlign',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'Td',
        typeName: null,
        propertyInfos: [{
            name: 'ifAndForEachAndSet',
            minOccurs: 0,
            collection: true,
            elementTypeInfos: [{
                elementName: 'if',
                typeInfo: '.If'
              }, {
                elementName: 'forEach',
                typeInfo: '.ForEach'
              }, {
                elementName: 'set',
                typeInfo: '.Set'
              }, {
                elementName: 'macroRef',
                typeInfo: '.MacroRef'
              }, {
                elementName: 'css',
                typeInfo: '.Css'
              }, {
                elementName: 'table',
                typeInfo: '.Table'
              }, {
                elementName: 'div',
                typeInfo: '.Div'
              }, {
                elementName: 'params',
                typeInfo: '.Params'
              }, {
                elementName: 'span',
                typeInfo: '.Span'
              }],
            type: 'elements'
          }, {
            name: 'id',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'id'
            },
            type: 'attribute'
          }, {
            name: 'scaleToFitContentByPdf',
            attributeName: {
              localPart: 'scaleToFitContentByPdf'
            },
            type: 'attribute'
          }, {
            name: 'explain',
            attributeName: {
              localPart: 'explain'
            },
            type: 'attribute'
          }, {
            name: 'cls',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cls'
            },
            type: 'attribute'
          }, {
            name: 'width',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'width'
            },
            type: 'attribute'
          }, {
            name: 'height',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'height'
            },
            type: 'attribute'
          }, {
            name: 'paddingLeft',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingLeft'
            },
            type: 'attribute'
          }, {
            name: 'paddingTop',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingTop'
            },
            type: 'attribute'
          }, {
            name: 'paddingRight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingRight'
            },
            type: 'attribute'
          }, {
            name: 'paddingBottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'paddingBottom'
            },
            type: 'attribute'
          }, {
            name: 'marginLeftByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginLeftByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginTopByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginTopByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginRightByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginRightByJs'
            },
            type: 'attribute'
          }, {
            name: 'marginBottomByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'marginBottomByJs'
            },
            type: 'attribute'
          }, {
            name: 'fontFamily',
            attributeName: {
              localPart: 'fontFamily'
            },
            type: 'attribute'
          }, {
            name: 'fontStyle',
            attributeName: {
              localPart: 'fontStyle'
            },
            type: 'attribute'
          }, {
            name: 'fontWeight',
            attributeName: {
              localPart: 'fontWeight'
            },
            type: 'attribute'
          }, {
            name: 'textDecoration',
            attributeName: {
              localPart: 'textDecoration'
            },
            type: 'attribute'
          }, {
            name: 'borderCollapse',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderCollapse'
            },
            type: 'attribute'
          }, {
            name: 'borderSpacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderSpacing'
            },
            type: 'attribute'
          }, {
            name: 'tableLayout',
            attributeName: {
              localPart: 'tableLayout'
            },
            type: 'attribute'
          }, {
            name: 'textAlign',
            attributeName: {
              localPart: 'textAlign'
            },
            type: 'attribute'
          }, {
            name: 'whiteSpace',
            attributeName: {
              localPart: 'whiteSpace'
            },
            type: 'attribute'
          }, {
            name: 'wordWrap',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'wordWrap'
            },
            type: 'attribute'
          }, {
            name: 'display',
            attributeName: {
              localPart: 'display'
            },
            type: 'attribute'
          }, {
            name: 'visibility',
            attributeName: {
              localPart: 'visibility'
            },
            type: 'attribute'
          }, {
            name: 'clear',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'clear'
            },
            type: 'attribute'
          }, {
            name: 'zoom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zoom'
            },
            type: 'attribute'
          }, {
            name: 'floatAlign',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'floatAlign'
            },
            type: 'attribute'
          }, {
            name: 'fontSize',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'fontSize'
            },
            type: 'attribute'
          }, {
            name: 'webkitBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'webkitBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'mozBoxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'mozBoxSizing'
            },
            type: 'attribute'
          }, {
            name: 'boxSizing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'boxSizing'
            },
            type: 'attribute'
          }, {
            name: 'minHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'minHeight'
            },
            type: 'attribute'
          }, {
            name: 'position',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'position'
            },
            type: 'attribute'
          }, {
            name: 'lineHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'lineHeight'
            },
            type: 'attribute'
          }, {
            name: 'color',
            attributeName: {
              localPart: 'color'
            },
            type: 'attribute'
          }, {
            name: 'borderTopWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderTopWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderTopStyle',
            attributeName: {
              localPart: 'borderTopStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderTopColor',
            attributeName: {
              localPart: 'borderTopColor'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderLeftWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftStyle',
            attributeName: {
              localPart: 'borderLeftStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderLeftColor',
            attributeName: {
              localPart: 'borderLeftColor'
            },
            type: 'attribute'
          }, {
            name: 'borderRightWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderRightWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderRightStyle',
            attributeName: {
              localPart: 'borderRightStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderRightColor',
            attributeName: {
              localPart: 'borderRightColor'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'borderBottomWidth'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomStyle',
            attributeName: {
              localPart: 'borderBottomStyle'
            },
            type: 'attribute'
          }, {
            name: 'borderBottomColor',
            attributeName: {
              localPart: 'borderBottomColor'
            },
            type: 'attribute'
          }, {
            name: 'maxWidth',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxWidth'
            },
            type: 'attribute'
          }, {
            name: 'left',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'left'
            },
            type: 'attribute'
          }, {
            name: 'top',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'top'
            },
            type: 'attribute'
          }, {
            name: 'right',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'right'
            },
            type: 'attribute'
          }, {
            name: 'bottom',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'bottom'
            },
            type: 'attribute'
          }, {
            name: 'verticalAlign',
            attributeName: {
              localPart: 'verticalAlign'
            },
            type: 'attribute'
          }, {
            name: 'overflowX',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowX'
            },
            type: 'attribute'
          }, {
            name: 'overflowY',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'overflowY'
            },
            type: 'attribute'
          }, {
            name: 'maxHeight',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'maxHeight'
            },
            type: 'attribute'
          }, {
            name: 'backgroundColor',
            attributeName: {
              localPart: 'backgroundColor'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImage',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImage'
            },
            type: 'attribute'
          }, {
            name: 'backgroundImageOpacityByPdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundImageOpacityByPdf'
            },
            type: 'attribute'
          }, {
            name: 'backgroundSize',
            attributeName: {
              localPart: 'backgroundSize'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionX',
            attributeName: {
              localPart: 'backgroundPositionX'
            },
            type: 'attribute'
          }, {
            name: 'backgroundPositionY',
            attributeName: {
              localPart: 'backgroundPositionY'
            },
            type: 'attribute'
          }, {
            name: 'transformByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'transformByJs'
            },
            type: 'attribute'
          }, {
            name: 'opacityByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'opacityByJs'
            },
            type: 'attribute'
          }, {
            name: 'zIndexByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'zIndexByJs'
            },
            type: 'attribute'
          }, {
            name: 'backgroundRepeatByJs',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'backgroundRepeatByJs'
            },
            type: 'attribute'
          }, {
            name: 'cellspacing',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellspacing'
            },
            type: 'attribute'
          }, {
            name: 'cellpadding',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'cellpadding'
            },
            type: 'attribute'
          }, {
            name: 'colspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'colspan'
            },
            type: 'attribute'
          }, {
            name: 'rowspan',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'rowspan'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.PaddingRight',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BorderSpacing',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.MozBoxSizing',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }, {
        localName: 'If.BackgroundImageOpacityByPdf',
        typeName: null,
        propertyInfos: [{
            name: 'js',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'js'
            },
            type: 'attribute'
          }, {
            name: 'pdf',
            typeInfo: 'AnySimpleType',
            attributeName: {
              localPart: 'pdf'
            },
            type: 'attribute'
          }]
      }],
    elementInfos: [{
        elementName: 'table',
        typeInfo: '.Table'
      }, {
        elementName: 'thead',
        typeInfo: '.Thead'
      }, {
        elementName: 'tr',
        typeInfo: '.Tr'
      }, {
        elementName: 'body',
        typeInfo: '.Body'
      }, {
        elementName: 'param',
        typeInfo: '.Param'
      }, {
        elementName: 'macro',
        typeInfo: '.Macro'
      }, {
        elementName: 'td',
        typeInfo: '.Td'
      }, {
        elementName: 'html',
        typeInfo: '.Html'
      }, {
        elementName: 'div',
        typeInfo: '.Div'
      }, {
        elementName: 'if',
        typeInfo: '.If'
      }, {
        elementName: 'macros',
        typeInfo: '.Macros'
      }, {
        elementName: 'css',
        typeInfo: '.Css'
      }, {
        elementName: 'tloop',
        typeInfo: '.Tloop'
      }, {
        elementName: 'forEach',
        typeInfo: '.ForEach'
      }, {
        elementName: 'macroRef',
        typeInfo: '.MacroRef'
      }, {
        elementName: 'tbody',
        typeInfo: '.Tbody'
      }, {
        elementName: 'style',
        typeInfo: '.Style'
      }, {
        elementName: 'th',
        typeInfo: '.Th'
      }, {
        elementName: 'tbottom',
        typeInfo: '.Tbottom'
      }, {
        elementName: 'set',
        typeInfo: '.Set'
      }, {
        elementName: 'span',
        typeInfo: '.Span'
      }, {
        elementName: 'params',
        typeInfo: '.Params'
      }]
  };
  return {
    nanhuprint: nanhuprint
  };
};
if (typeof define === 'function' && define.amd) {
  define([], nanhuprint_Module_Factory);
}
else {
  var nanhuprint_Module = nanhuprint_Module_Factory();
  if (typeof module !== 'undefined' && module.exports) {
    module.exports.nanhuprint = nanhuprint_Module.nanhuprint;
  }
  else {
    var nanhuprint = nanhuprint_Module.nanhuprint;
  }
}