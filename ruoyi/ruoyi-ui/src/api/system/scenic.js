import request from '@/utils/request'

// 查询景区管理列表
export function listScenic(query) {
  return request({
    url: '/system/scenic/list',
    method: 'get',
    params: query
  })
}

// 查询景区管理详细
export function getScenic(scenicId) {
  return request({
    url: '/system/scenic/' + scenicId,
    method: 'get'
  })
}

// 新增景区管理
export function addScenic(data) {
  return request({
    url: '/system/scenic',
    method: 'post',
    data: data
  })
}

// 修改景区管理
export function updateScenic(data) {
  return request({
    url: '/system/scenic',
    method: 'put',
    data: data
  })
}

// 删除景区管理
export function delScenic(scenicId) {
  return request({
    url: '/system/scenic/' + scenicId,
    method: 'delete'
  })
}
