import request from '@/utils/request'

// 查询景区设施，存储景区设施列表
export function listFacility(query) {
  return request({
    url: '/system/facility/list',
    method: 'get',
    params: query
  })
}

// 查询景区设施，存储景区设施详细
export function getFacility(facilityId) {
  return request({
    url: '/system/facility/' + facilityId,
    method: 'get'
  })
}

// 新增景区设施，存储景区设施
export function addFacility(data) {
  return request({
    url: '/system/facility',
    method: 'post',
    data: data
  })
}

// 修改景区设施，存储景区设施
export function updateFacility(data) {
  return request({
    url: '/system/facility',
    method: 'put',
    data: data
  })
}

// 删除景区设施，存储景区设施
export function delFacility(facilityId) {
  return request({
    url: '/system/facility/' + facilityId,
    method: 'delete'
  })
}
